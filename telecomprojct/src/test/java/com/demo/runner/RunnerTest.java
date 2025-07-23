package com.demo.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")


@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/feature")

@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.demo.stepdefinition,com.demo.hooks")

@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")

@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@clearform")

@ConfigurationParameter(key = Constants.PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")

//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:,rerun:target/rerun.txt")




public class RunnerTest {
}
