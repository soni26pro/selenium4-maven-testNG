package io.github.suju26pro.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Implements TestNG's IAnnotationTransformer interface to apply Retry logic to test methods.
 */
public class RetryListener implements IAnnotationTransformer {

  @Override
  public void transform(final ITestAnnotation annotation, final Class testClass,
                        final Constructor testConstructor, final Method testMethod) {
    if (testMethod != null && testMethod.getDeclaringClass() != null) {
      annotation.setRetryAnalyzer(Retry.class);
    }
  }
}
