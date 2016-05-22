/**
 * 
 */
package com.glority.quality.connector.supportdb;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.Project;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.SupportTicketStatus;
import com.glority.quality.connectors.supportdb.CreateTimeFilter;
import com.glority.quality.connectors.supportdb.GlorityOperationsDBTask;
import com.glority.quality.connectors.supportdb.StatusFilter;
import com.glority.quality.connectors.supportdb.SupportDBBaseTask;
import com.glority.quality.connectors.supportdb.SupportTicketFilter;
import com.glority.quality.model.SupportTicket;

/**
 * . GlorityOperationsDBTaskTest .
 * 
 * @author CLB.
 * 
 */
public class GlorityOperationsDBTaskTest {
    public static final int SUPPORT_LIST_TOTAL_SIZE = 3;
    public static final int SUPPORT_LIST_TIME_FILTERED_SIZE = 2;
    public static final int SUPPORT_LIST_STATUS_WORKING_SIZE = 1;

    private SupportDBBaseTask task = new GlorityOperationsDBTask();

    @Before
    public void setUp() throws IOException {
        String inputFilePath = "testtasks" + File.separator + "res" + File.separator
                + "GlorityOperationsDBTaskTestData.xml";
        InputStream inputStream = new FileInputStream(inputFilePath);
        String xml = IOUtils.toString(inputStream);
        TGlorityOperationsDBClient tclient = new TGlorityOperationsDBClient();
        tclient.setXmlString(xml);
        this.task.setSupportDbClient(tclient);
        this.task.setProject(new Project());
        this.task.execute();
    }

    @Test
    public void testGetAllTickets() throws ParseException {
        List<SupportTicket> supportTicketList = this.task.getTickets();
        assertEquals(SUPPORT_LIST_TOTAL_SIZE, supportTicketList.size());
    }

    @Test
    public void testGetTicketsThroughCreateTimeFilter() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = simpleDateFormat.parse("2012-12-06");
        Date end = simpleDateFormat.parse("2012-12-09");
        CreateTimeFilter cFilter = new CreateTimeFilter();
        cFilter.setStartDate(start);
        cFilter.setEndDate(end);
        List<SupportTicketFilter> filterList = new ArrayList<SupportTicketFilter>();
        filterList.add(cFilter);
        this.task.setFilters(filterList);
        List<SupportTicket> supportTicketList = this.task.getTickets();
        assertEquals(SUPPORT_LIST_TIME_FILTERED_SIZE, supportTicketList.size()); 
    }
    
    @Test
    public void testGetTicketsThroughStatusFilter() throws ParseException {
        StatusFilter sFilter = new StatusFilter();
        List<SupportTicketStatus> statusList = new ArrayList<SupportTicketStatus>();
        statusList.add(SupportTicketStatus.WORKING);
        sFilter.setStatusList(statusList);
        List<SupportTicketFilter> filterList = new ArrayList<SupportTicketFilter>();
        filterList.add(sFilter);
        this.task.setFilters(filterList);
        List<SupportTicket> supportTicketList = this.task.getTickets();
        assertEquals(SUPPORT_LIST_STATUS_WORKING_SIZE, supportTicketList.size()); 
    }
}
