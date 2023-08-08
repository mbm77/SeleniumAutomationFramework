package com.mbm.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.mbm.utils.DataProviderUtils;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
		
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		
	}

}
