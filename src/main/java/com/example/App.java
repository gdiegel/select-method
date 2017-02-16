package com.example;

import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectMethod;

public class App {

    public static void main(String[] args) throws NoSuchMethodException {
        final Class<TestClassWithTwoMethods> testClass = TestClassWithTwoMethods.class;
        final MethodSource methodSource1 = new MethodSource(testClass.getName(), testClass.getMethod("one").getName());
        final MethodSource methodSource2 = new MethodSource(testClass.getName(), testClass.getMethod("two").getName());
        final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectMethod(methodSource1.getClassName(), methodSource1.getMethodName()),
                        selectMethod(methodSource2.getClassName(), methodSource2.getMethodName())
                ).build();
        final Launcher launcher = LauncherFactory.create();
        final SummaryGeneratingListener summaryGeneratingListener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(summaryGeneratingListener);
        launcher.execute(request);
        summaryGeneratingListener.getSummary().printTo(new PrintWriter(System.out));
    }
}
