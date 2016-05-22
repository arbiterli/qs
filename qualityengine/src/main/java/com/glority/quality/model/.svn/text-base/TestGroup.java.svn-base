package com.glority.quality.model;

import java.util.List;
/**
 * Test Group.
 * @author liheping
 *
 */
public class TestGroup {
    private String id;
    private List<Test> tests;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestGroup [id=");
        builder.append(id);
        builder.append(", tests=");
        builder.append(tests);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tests == null) ? 0 : tests.hashCode());
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
        if (!(obj instanceof TestGroup)) {
            return false;
        }
        TestGroup other = (TestGroup) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (tests == null) {
            if (other.tests != null) {
                return false;
            }
        } else if (!tests.equals(other.tests)) {
            return false;
        }
        return true;
    }

}
