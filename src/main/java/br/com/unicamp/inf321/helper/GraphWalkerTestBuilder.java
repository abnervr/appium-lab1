package br.com.unicamp.inf321.helper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.graphwalker.core.event.Observer;
import org.graphwalker.core.generator.PathGenerator;
import org.graphwalker.core.machine.Context;
import org.graphwalker.dsl.antlr.generator.GeneratorFactory;
import org.graphwalker.io.factory.ContextFactory;
import org.graphwalker.io.factory.ContextFactoryException;
import org.graphwalker.io.factory.ContextFactoryScanner;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutionException;
import org.graphwalker.java.test.TestExecutor;

@SuppressWarnings("rawtypes")
public class GraphWalkerTestBuilder {
	private List<Context> contexts = new ArrayList<>();
	private Set<Observer> observers = new HashSet<>();

	public GraphWalkerTestBuilder addModel(String model) {
		return addModel(Paths.get(model));
	}

	public GraphWalkerTestBuilder addModel(Path model) {
		contexts.add(createContext(model, null, null, null));
		return this;
	}

	
	public GraphWalkerTestBuilder addModel(String model, PathGenerator pathGenerator) {
		return addModel(Paths.get(model), pathGenerator);
	}

	public GraphWalkerTestBuilder addModel(Path model, PathGenerator pathGenerator) {
		contexts.add(createContext(model, null, pathGenerator, null));
		return this;
	}

	public GraphWalkerTestBuilder addModel(String model, PathGenerator pathGenerator, String start) {
		return addModel(Paths.get(model), pathGenerator, start);
	}

	public GraphWalkerTestBuilder addModel(Path model, PathGenerator pathGenerator, String start) {
		contexts.add(createContext(model, null, pathGenerator, start));
		return this;
	}
	
	public GraphWalkerTestBuilder addModel(Path model, PathGenerator pathGenerator, String start, Context context) {
		contexts.add(createContext(model, context, pathGenerator, start));
		return this;
	}
	
	public GraphWalkerTestBuilder addModel(Path model, PathGenerator pathGenerator, Context context) {
		contexts.add(createContext(model, context, pathGenerator, null));
		return this;
	}

	public GraphWalkerTestBuilder addModel(String model, Context context) {
		return addModel(Paths.get(model), context);
	}

	public GraphWalkerTestBuilder addModel(Path model, Context context) {
		contexts.add(createContext(model, context, null, null));
		return this;
	}

	private Context createContext(Path model, Context context, PathGenerator pathGenerator, String start) {
		ContextFactory factory = ContextFactoryScanner.get(model);
		Context newContext;
		try {
			if (null != context) {
				newContext = factory.create(model, context);
			} else {
				newContext = factory.create(model);
			}
			if (null != pathGenerator) {
				newContext.setPathGenerator(pathGenerator);
			}
			if (null != start) {
				newContext.setNextElement(newContext.getModel().findElements(start).get(0));
			}
		} catch (Throwable t) {
			throw new ContextFactoryException("Failed to create context", t);
		}
		return newContext;
	}

	public GraphWalkerTestBuilder addContext(Context context) {
		contexts.add(context);
		return this;
	}

	public GraphWalkerTestBuilder addClass(Class<? extends Context> testClass) {
		contexts.add(createContext(testClass));
		return this;
	}

	public GraphWalkerTestBuilder addClass(Class<? extends Context> testClass, String pathGenerator) {
		return addClass(testClass, GeneratorFactory.parse(pathGenerator));
	}

	public GraphWalkerTestBuilder addClass(Class<? extends Context> testClass, PathGenerator pathGenerator) {
		Context context = createContext(testClass);
		context.setPathGenerator(pathGenerator);
		contexts.add(context);
		return this;
	}

	private Context createContext(Class<? extends Context> testClass) {
		try {
			return testClass.newInstance();
		} catch (Throwable t) {
			throw new ContextFactoryException("Failed to create context", t);
		}
	}

	public Result execute(boolean ignoreError) {
		if (!contexts.isEmpty()) {
			TestExecutor executor = new TestExecutor(contexts);
			for(Observer observer : observers){				
				executor.getMachine().addObserver(observer);
			}
			return executor.execute(ignoreError);
		} else {
			throw new TestExecutionException("The contexts must be not empty!");
		}
	}

	public GraphWalkerTestBuilder addObserver(Observer observer) {
		observers.add(observer);
		return this;
	}

	public Result execute() {
		return execute(false);
	}

}
