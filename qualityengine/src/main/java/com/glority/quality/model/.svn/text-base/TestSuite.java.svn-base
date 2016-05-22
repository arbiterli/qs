package com.glority.quality.model;

import java.util.List;
/**
 * Test Suite model.
 * @author liheping
 *
 */
public class TestSuite {
    private String configurationId;
    private String testId;
    private String type;
    private List<TestCase> testCases;

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestSuite [configurationId=");
        builder.append(configurationId);
        builder.append(", testId=");
        builder.append(testId);
        builder.append(", type=");
        builder.append(type);
        builder.append(", testCases=");
        builder.append(testCases);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((configurationId == null) ? 0 : configurationId.hashCode());
        result = prime * result + ((testCases == null) ? 0 : testCases.hashCode());
        result = prime * result + ((testId == null) ? 0 : testId.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TestSuite)) {
            return false;
        }
        TestSuite other = (TestSuite) obj;
        if (configurationId == null) {
            if (other.configurationId != null) {
                return false;
            }
        } else if (!configurationId.equals(other.configurationId)) {
            return false;
        }
        if (testCases == null) {
            if (other.testCases != null) {
                return false;
            }
        } else if (!testCases.equals(other.testCases)) {
            return false;
        }
        if (testId == null) {
            if (other.testId != null) {
                return false;
            }
        } else if (!testId.equals(other.testId)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

}
