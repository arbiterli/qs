package com.glority.quality.connectors.testrail;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringEscapeUtils;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.http.HttpConnector;
import com.glority.quality.Constants.TCResult;
import com.glority.quality.Constants.TCStatus;
import com.glority.quality.Constants.TestRunType;
import com.glority.quality.model.TestCase;

/**
 * to serve as a adapter to testrail.
 * 
 * @author zm
 * 
 */
public class TestrailAdapterImpl implements TestrailAdapter {

    /**
     * the server of testrail.
     */
    private String testrailServer;
    /**
     * the key of testrail miniapi.
     */
    private String testrailKey;
    /**
     * the url prefix.
     */
    private static final String URL_PREFIX = "/index.php?/miniapi/";

    /**
     * to config the adapter.
     * 
     * @param server
     *            the server.
     * @param key
     *            the testrail miniapi key.
     */
    public void config(final String server, final String key) {
        this.testrailServer = server;
        this.testrailKey = key;
    }

    /**
     * to get testcases of a product.
     * 
     * @param id
     *            the id of product.
     * @return a list of test cases.
     * @throws ConnectorException
     */
    public List<TestCase> getTestCasesOfProduct(final String id) throws ConnectorException {
        String url = this.testrailServer + URL_PREFIX
                + "get_testcases_of_product/" + id + "&key=" + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);
    }

    /**
     * to get test cases of a version.
     * 
     * @param id
     *            the id of product.
     * @param version
     *            the version.
     * @return a list of test cases.
     * @throws ConnectorException
     */
    public List<TestCase> getTestCasesOfVersion(final String id,
            final String version) throws ConnectorException {
        String url = this.testrailServer + URL_PREFIX
                + "get_testcases_of_version/" + id + "/" + version + "&key="
                + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);
    }

    /**
     * to get nightly build tests.
     * 
     * @param id
     *            the id of a product.
     * @param version
     *            the version.
     * @return a list of test cases.
     * @throws ConnectorException
     */
    public List<TestCase> getNightlyBuildTests(final String id,
            final String version) throws ConnectorException {
        List<TestCase> result = new ArrayList<TestCase>();
        result.addAll(getStableNightlyBuildTestCases(id, version));
        result.addAll(getUnstableNightlyBuildTestCases(id, version));
        return result;
    }

    /**
     * to update test result.
     * 
     * @param id
     *            the test id
     * @param result
     *            the result
     * @param message
     *            the message
     * @throws ConnectorException
     */
    public void updateTestResult(final String id, final String result,
            final String message) throws ConnectorException {
        String url = this.testrailServer + URL_PREFIX + "add_result/" + id
                + "&key=" + this.testrailKey;
        Map<String, String> params = new HashMap<String, String>();
        params.put("status_id", result);
        params.put("comment", message);

        new HttpConnector().doPost(url, params);
    }

    public List<TestCase> getSingleTestCase(final String caseId) throws ConnectorException {
        String url = this.testrailServer + URL_PREFIX
                + "get_case_with_dependency/" + caseId + "&key="
                + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);
    }

    /**
     * to get testrun result.
     * 
     * @param id
     *            the test run id.
     * @return a list of test cases.
     * @throws ConnectorException
     */
    public List<TestCase> getTestRunResult(final String id) throws ConnectorException {
        String url = this.testrailServer + URL_PREFIX
                + "get_testcases_of_testrun/" + id + "&key=" + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);
    }

    /**
     * to get test tun by name.
     * 
     * @param productId
     *            product id.
     * @param version
     *            version.
     * @param type
     *            type.
     * @return
     * @throws ConnectorException
     */
    public List<TestCase> getTestRunResult(final String productId,
            final String version, final TestRunType type) throws ConnectorException {
        String url = this.testrailServer + URL_PREFIX
                + "get_testcases_of_testrun_by_type/" + productId + "/"
                + version + ":" + type.toString() + "&key=" + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);
    }

    /**
     * to parseResult.
     * 
     * @param status
     *            the status.
     * @return the result.
     */
    private String parseResult(final int status) {
        TCResult result = TCResult.getTCResult(status);
        return result.toString();
    }

    /**
     * a json sample as below.
     * {"cases":[{"id":397,"created_on":1351203310,"name"
     * :"WinZip_17_WXF","status_id":2},
     * {"id":399,"created_on":1351203342,"name":
     * "WinZip_17_WXF","status_id":3,"custom_dependency":112}],"result":true}
     * 
     * @param json
     *            the json string.
     * @return a list of test case.
     */
    private List<TestCase> parseTestCase(final String json) {
        List<TestCase> testCases = new ArrayList<TestCase>();
        JSONObject jsonObject = JSONObject.fromObject(json);
        JSONArray items = jsonObject.getJSONArray("cases");
        for (int i = 0; i < items.size(); i++) {
            TestCase tmpTC = new TestCase();
            JSONObject item = JSONObject.fromObject(items.get(i));
            String id = StringEscapeUtils.escapeSql(item.getString("id"));
            tmpTC.setId(id);
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String time = sdf.format(new Timestamp(Integer
                    .parseInt(StringEscapeUtils.escapeSql(item
                            .getString("created_on")))));
            tmpTC.setTime(time);
            String tcDependency = StringEscapeUtils.escapeSql(item
                    .getString("custom_dependency"));
            tmpTC.setDependency(tcDependency);
            String tcStatus = StringEscapeUtils.escapeSql(item
                    .getString("custom_tc_status"));
            if (!tcStatus.equals("null")) {
                TCStatus status = TCStatus.getTCStatus(Integer
                        .parseInt(tcStatus));
                tmpTC.setStatus(status);
            }
            String tcResult = StringEscapeUtils.escapeSql(item
                    .getString("status_id"));
            if (!tcResult.equals("null")) {
                int result = Integer.parseInt(tcResult);
                tmpTC.setResult(parseResult(result));
            }
            testCases.add(tmpTC);
        }
        return testCases;
    }

    /**
     * to get stable nightly build test cases.
     * 
     * @param id
     *            the id of product.
     * @param version
     *            the version of a product.
     * @return a list of test cases.
     * @throws ConnectorException
     */
    private List<TestCase> getStableNightlyBuildTestCases(final String id,
            final String version) throws ConnectorException {
        String url = "http://" + this.testrailServer + URL_PREFIX
                + "get_stable_nightly_build_testcases/" + id + "/" + version
                + "&key=" + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);
    }

    /**
     * to get unstable nightly build test cases.
     * 
     * @param id
     *            the id of product.
     * @param version
     *            the version of a product.
     * @return a list of result.
     * @throws ConnectorException
     */
    private List<TestCase> getUnstableNightlyBuildTestCases(final String id,
            final String version) throws ConnectorException {
        String url = "http://" + this.testrailServer + URL_PREFIX
                + "get_unstable_nightly_build_testcases/" + id + "/" + version
                + "&key=" + this.testrailKey;
        String result = new HttpConnector().doGet(url);
        return parseJSONToTestCaseList(result);

    }

    private List<TestCase> parseJSONToTestCaseList(String json) {
        List<TestCase> resultTC = parseTestCase(json);
        resultTC = sortList(resultTC);
        return resultTC;
    }

    private List<TestCase> sortList(List<TestCase> oriList) {
        List<TestCase> result = new ArrayList<TestCase>();
        boolean isExist = false;
        for (int i = 0; i < oriList.size(); i++) {
            TestCase tmpCase = oriList.get(i);
            if (result.size() == 0) {
                result.add(tmpCase);
                continue;
            }
            for (int j = 0; j < result.size(); j++) {
                if (tmpCase.getId().equals(result.get(j).getId())) {
                    isExist = true;
                    break;
                }
                if (tmpCase.getId().equals(result.get(j).getDependency())) {
                    result.add(j, tmpCase);
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                isExist = false;
                continue;
            }
            result.add(tmpCase);
        }
        return result;
    }
}
