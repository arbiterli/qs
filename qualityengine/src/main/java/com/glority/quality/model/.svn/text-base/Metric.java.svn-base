package com.glority.quality.model;

import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;

/**
 * This is a data model objects that fully represent a metric Like MI, CPD and so on. All checkable value we can get
 * from build/test will be represented as a metric
 * 
 * @author XQS
 * 
 */

public class Metric {
    private String name;
    private MetricType type;
    private String newValue;
    private String oldValue;
    private MetricResult result;
    private String time;
    private int faileCount;
    private String failure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetricType getType() {
        return type;
    }

    public void setType(MetricType type) {
        this.type = type;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public MetricResult getResult() {
        return result;
    }

    public void setResult(MetricResult result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNewValue(int value) {
        this.newValue = "" + value;
    }

    public void setNewValue(float value) {
        this.newValue = "" + value;
    }

    public int getFaileCount() {
        return faileCount;
    }

    public void setFaileCount(int faileCount) {
        this.faileCount = faileCount;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Metric [name=");
        builder.append(name);
        builder.append(", type=");
        builder.append(type);
        builder.append(", newValue=");
        builder.append(newValue);
        builder.append(", oldValue=");
        builder.append(oldValue);
        builder.append(", result=");
        builder.append(result);
        builder.append(", time=");
        builder.append(time);
        builder.append(", faileCount=");
        builder.append(faileCount);
        builder.append(", failure=");
        builder.append(failure);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + faileCount;
        result = prime * result + ((failure == null) ? 0 : failure.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((newValue == null) ? 0 : newValue.hashCode());
        result = prime * result + ((oldValue == null) ? 0 : oldValue.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        if (!(obj instanceof Metric)) {
            return false;
        }
        Metric other = (Metric) obj;
        if (faileCount != other.faileCount) {
            return false;
        }
        if (failure == null) {
            if (other.failure != null) {
                return false;
            }
        } else if (!failure.equals(other.failure)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (newValue == null) {
            if (other.newValue != null) {
                return false;
            }
        } else if (!newValue.equals(other.newValue)) {
            return false;
        }
        if (oldValue == null) {
            if (other.oldValue != null) {
                return false;
            }
        } else if (!oldValue.equals(other.oldValue)) {
            return false;
        }
        if (result != other.result) {
            return false;
        }
        if (time == null) {
            if (other.time != null) {
                return false;
            }
        } else if (!time.equals(other.time)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

}
