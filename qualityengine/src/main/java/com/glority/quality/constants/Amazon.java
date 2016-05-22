/**
 * 
 */
package com.glority.quality.constants;

/**
 * Amazon
 * @author Administrator
 * 
 */
public class Amazon {
    /**
     * metric name of amazon.
     * 
     * @author CLB
     */
    public enum AmazonMetricName {
        CPU_UTILIZATION("CPUUtilization"), // CPU Utilization
        DISK_READ_BYTES("DiskReadBytes"), // Disk Read Bytes
        DISK_READ_OPS("DiskReadOps"), // Disk Read Ops
        DISK_WRITE_BYTES("DiskWriteBytes"), // Disk Write Bytes
        DISK_WRITE_OPS("DiskWriteOps"), // Disk Write Ops
        NETWORK_IN("NetworkIn"), // Network In
        NETWORK_OUT("NetworkOut"), // Network Out
        STATUS_CHECK_FAILED("StatusCheckFailed"), // Status Check Failed
        STATUS_CHECK_FAILED_INSTANCE("StatusCheckFailed_Instance"), // Status Check Failed Instance
        STATUS_CHECK_FAILED_SYSTEM("StatusCheckFailed_System"); // Status Check Failed System"
        private String value;

        /**
         * get value.
         *
         * @param name
         *            the value.
         */
        private AmazonMetricName(String name) {
            this.value = name;
        }

        /**
         * to string method.
         *
         * @return value
         */
        @Override
        public String toString() {
            return this.value;
        }

        /**
         * get enum value of name.
         *
         * @param name
         *            the name.
         * @return metricName
         */
        public static AmazonMetricName getValueOf(String name) {
            for (AmazonMetricName metricName : AmazonMetricName.values()) {
                if (metricName.toString().equals(name)) {
                    return metricName;
                }
            }
            return null;
        }
    }

    /**
     * metric name space.
     * 
     * @author CLB
     */
    public enum AmazonMetricNamespace {
        EC2("AWS/EC2"), // AWS EC2
        BILLING("AWS/Billing"), // AWS Billing
        DYNAMODB("AWS/DynamoDB"), // AWS DynamoDB
        ELASTICACHE("AWS/ElastiCache"), // AWS ElastiCache
        EBS("AWS/EBS"), // AWS EBS
        ELASTIC_MAP_REDUCE("AWS/ElasticMapReduce"), // AWS ElasticMapReduce
        RDS("AWS/RDS"), // AWS RDS
        SNS("AWS/SNS"), // AWS SNS
        SQS("AWS/SQS"), // AWS SQS
        STORAGE_GATEWAY("AWS/StorageGateway"), // AWS StorageGateway
        AUTO_SCALING("AWS/AutoScaling"), // AWS AutoScaling
        ELB("AWS/ELB"); // AWS ELB
        private String value;

        /**
         * set namespace.
         *
         * @param namespace
         *            the namespace.
         */
        private AmazonMetricNamespace(String namespace) {
            this.value = namespace;
        }

        /**
         * to string method.
         *
         * @return value.
         */
        @Override
        public String toString() {
            return this.value;
        }

        /**
         * get enum value of namespace.
         *
         * @param namespace
         *            the namespace.
         * @return metricNamespace.
         */
        public static AmazonMetricNamespace getValueOf(String namespace) {
            for (AmazonMetricNamespace metricNamespace : AmazonMetricNamespace.values()) {
                if (metricNamespace.toString().equals(namespace)) {
                    return metricNamespace;
                }
            }
            return null;
        }
    }

    /**
     * metric name space.
     * 
     * @author CLB
     */
    public enum AmazonDimensionName {
        INSTANCE_ID("InstanceId"), // instance id
        AUTO_SCALING_GROUP_NAME("AutoScalingGroupName"), // Auto Scaling Group Name
        IMAGE_ID("ImageId"), // Image Id
        INSTANCE_TYPE("InstanceType"); // Instance Type
        private String value;

        /**
         * set id.
         *
         * @param id
         *            the id.
         */
        private AmazonDimensionName(String id) {
            this.value = id;
        }

        /**
         * to string method.
         *
         * @return value.
         */
        @Override
        public String toString() {
            return this.value;
        }

        /**
         * get DimensionName.
         *
         * @param name
         *            the name.
         * @return DimensionName
         */
        public static AmazonDimensionName getValueOf(String name) {
            for (AmazonDimensionName dimensionName : AmazonDimensionName.values()) {
                if (dimensionName.toString().equals(name)) {
                    return dimensionName;
                }
            }
            return null;
        }
    }

    /**
     * AmazonEndPoint.
     * 
     * @author CLB
     * 
     */
    public enum AmazonEndPoint {
        US_WEST_2("monitoring.us-west-2.amazonaws.com"), // US West (Oregon) Region
        US_EAST_1("monitoring.us-east-1.amazonaws.com"), // US East (Northern Virginia) Region
        US_WEST_1("monitoring.us-west-1.amazonaws.com"), // US West (Northern California) Region
        EU_WEST_1("monitoring.eu-west-1.amazonaws.com"), // EU (Ireland) Region
        AP_SOUTHEAST_1("monitoring.ap-southeast-1.amazonaws.com"), // Asia Pacific (Singapore) Region
        AP_SOUTHEAST_2("monitoring.ap-southeast-2.amazonaws.com"), // Asia Pacific (Sydney) Region
        AP_NORTHEAST_1("monitoring.ap-northeast-1.amazonaws.com"), // Asia Pacific (Tokyo) Region
        SA_EAST_1("monitoring.sa-east-1.amazonaws.com"); // South America (Sao Paulo) Region
        private String value;

        /**
         * set region.
         *
         * @param region
         *            the region.
         */
        private AmazonEndPoint(String region) {
            this.value = region;
        }

        /**
         * to string method.
         *
         * @return value.
         */
        @Override
        public String toString() {
            return this.value;
        }

        /**
         * get AmazonEndPoint.
         *
         * @param name
         *            the name.
         * @return AmazonEndPoint.
         */
        public static AmazonEndPoint getValueOf(String name) {
            for (AmazonEndPoint endpoint : AmazonEndPoint.values()) {
                if (endpoint.toString().equals(name)) {
                    return endpoint;
                }
            }
            return null;
        }
    }
}
