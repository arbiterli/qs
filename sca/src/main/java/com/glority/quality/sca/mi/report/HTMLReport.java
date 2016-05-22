package com.glority.quality.sca.mi.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.glority.quality.sca.antlr.LanguageParserFactory.LanguageEnum;
import com.glority.quality.sca.mi.metrics.FileMetrics;
import com.glority.quality.sca.mi.metrics.FunctionMetrics;
import com.glority.quality.sca.mi.metrics.ProjectMetrics;

/**
 * Generate HTML report.
 * 
 * @author LYX
 */
public class HTMLReport {
    private static final Logger LOGGER = Logger.getLogger(HTMLReport.class);
    private ProjectMetrics pmi;
    private LanguageEnum lang;
    private String reportPath;
    private static final float GOODCMI = 130;

    public static final DecimalFormat FMT = new DecimalFormat("#.##");

    public HTMLReport(ProjectMetrics pmi, LanguageEnum lang, String reportPath) {
        this.pmi = pmi;
        this.lang = lang;
        this.reportPath = reportPath;
    }

    public void writeReport(String fileName) {
        try {
            if ("sorted".equals(fileName)) {
                pmi.sortFiles();
            }
            String reportFile = this.reportPath + File.separator + fileName + ".html";
            OutputStream os = new FileOutputStream(reportFile);

            File file = new File(this.reportPath + File.separator + fileName + "files");
            // a new fold for single file report
            if (!file.exists()) {
                file.mkdir();
            }
            writeHeaderInHTML(os);
            os.write(("<body><table class=\"hdft\" cellspacing=\"0\" width=\"100%\"><tr><th class=\"tl\">"
                    + "quality system</th></tr>" + "<tr><td class=\"nv\">[<a href=\"mi.html\">project</a>]"
                    + " [<a href=\"bad.html\">bad functions</a>]</td></tr></table>\n").getBytes());
            writeSummaryTable(os);

            writeFileDetailTable(os, fileName, false);

            for (int i = 0; i < pmi.getFiles().size(); i++) {
                FileMetrics fm = (FileMetrics) pmi.getFiles().get(i);
                if (fm.getFileOrder() < 0) {
                    fm.setFileOrder(i);
                }
                writeSingleFile(fm.getFileOrder(), fm, fileName);
            }

            os.write("</table>".getBytes());
            os.write("</body>".getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void initMergeReport(String fileName, OutputStream os) {
        try {
            if ("sorted".equals(fileName)) {
                pmi.sortFiles();
            }

            File file = new File(this.reportPath + File.separator + fileName + "files");
            // a new fold for single file report
            if (!file.exists()) {
                file.mkdir();
            }
            writeHeaderInHTML(os);
            os.write(("<body><table class=\"hdft\" cellspacing=\"0\" width=\"100%\"><tr><th class=\"tl\">"
                    + "quality system</th></tr>" + "<tr><td class=\"nv\">[<a href=\"mi.html\">project</a>]"
                    + " [<a href=\"bad.html\">bad functions</a>]</td></tr></table>\n").getBytes());
            writeSummaryTable(os);
            if ("mi".equals(fileName)) {
                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>file "
                        + "<a href=\"sorted.html\">(order by CMI)</a></th><th>totalloc</th>"
                        + "<th>totallom</th><th>avgloc</th>" + "<th>avglom</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());
            } else {
                // sorted report
                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>file "
                        + "<a href=\"mi.html\">(back)</a></th><th>totalloc</th>"
                        + "<th>totallom</th><th>avgloc</th>" + "<th>avglom</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void mergeReport(String fileName, FileMetrics fm, OutputStream os) {
        try {
            addToFileDetailTable(fileName, fm, os);
            writeSingleFile(fm.getFileOrder(), fm, fileName);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    private void addToFileDetailTable(String fileName, FileMetrics fm, OutputStream os) {
        try {
            if (fm.getCmi() < GOODCMI) {
                os.write(("<tr><td>[<a href=\"" + fileName + "files/" + fm.getFileOrder()
                        + ".html\"><font color=\"red\">" + fm.getFilePath() + "</font></a>]</td><td>"
                        + fm.getLoc() + "</td><td>" + fm.getLom() + "</td><td>" + FMT.format(fm.getAvgLoc())
                        + "</td><td>" + FMT.format(fm.getAvgLom()) + "</td><td>"
                        + FMT.format(fm.getAvgHalsteadVolume()) + "</td><td>"
                        + FMT.format(fm.getAvgCcVolume()) + "</td><td>" + FMT.format(fm.getMi())
                        + "</td><td>" + FMT.format(fm.getCmi()) + "</td></tr>").getBytes());
            } else {
                os.write(("<tr><td>[<a href=\"" + fileName + "files/" + fm.getFileOrder() + ".html\">"
                        + fm.getFilePath() + "</a>]</td><td>" + fm.getLoc() + "</td><td>" + fm.getLom()
                        + "</td><td>" + FMT.format(fm.getAvgLoc()) + "</td><td>" + FMT.format(fm.getAvgLom())
                        + "</td><td>" + FMT.format(fm.getAvgHalsteadVolume()) + "</td><td>"
                        + FMT.format(fm.getAvgCcVolume()) + "</td><td>" + FMT.format(fm.getMi())
                        + "</td><td>" + FMT.format(fm.getCmi()) + "</td></tr>").getBytes());
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeSingleFile(int fileNum, FileMetrics fm, String fileName) {
        try {
            OutputStream fos = new FileOutputStream(this.reportPath + File.separator + fileName + "files"
                    + File.separator + fileNum + ".html");

            fos.write(("<head><meta content=\"text/html; charset=utf8\" HTTP-EQUIV=\"Content-Type\"/>"
                    + "<title>Quality System Report" + "</title>" + "<link rel=\"stylesheet\" "
                    + "type=\"text/css\" href=\"../../mireport.css\"/></head>\n").getBytes());

            fos.write(("<body><table class=\"hdft\" cellspacing=\"0\" width=\"100%\"><tr><th class=\"tl\">"
                    + fm.getFilePath() + "</th></tr>" + "<tr><td class=\"nv\">[<a href=\"../mi.html\">"
                    + "project</a>] " + "[<a href=\"../bad.html\">bad functions</a>]</td></tr></table>\n")
                    .getBytes());

            writeSingleFileSummaryTable(fos, fm, fileName);
            fos.write("FUNCTION DETAIL\n".getBytes());
            writeFunctionDetailTable(fileNum, fos, fm, fileName);
            fos.write("</table>".getBytes());
            fos.write("</body>".getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeHeaderInHTML(OutputStream os) {
        try {
            os.write(("<head><meta content=\"text/html; charset=utf8\" HTTP-EQUIV=\"Content-Type\"/>"
                    + "<title>quality system reports</title>" + "<link rel=\"stylesheet\" type=\"text/css"
                    + "\" href=\"../mireport.css\"/></head>\n").getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeSummaryTable(OutputStream os) {
        try {
            os.write("SUMMARY\n".getBytes());

            os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>name</th><th>totalloc"
                    + "</th><th>totallom</th><th>avgloc</th>" + "<th>avglom</th><th>avghalsteadvolume"
                    + "</th><th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                    .getBytes());

            os.write(("<tr><td>projectMI</td><td>" + pmi.getLoc() + "</td><td>" + pmi.getLom() + "</td><td>"
                    + FMT.format(pmi.getAvgLoc()) + "</td><td>" + FMT.format(pmi.getAvgLom()) + "</td><td>"
                    + FMT.format(pmi.getAvgHalsteadVolume()) + "</td><td>" + FMT.format(pmi.getAvgCcVolume())
                    + "</td><td>" + FMT.format(pmi.getMi()) + "</td><td>" + FMT.format(pmi.getCmi())
                    + "</td></tr></table>")
                    .getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeFileDetailTable(OutputStream os, String fileName, boolean isBad) {
        try {
            os.write("DETAIL\n".getBytes());
            // unsorted report
            if ("mi".equals(fileName)) {
                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>file "
                        + "<a href=\"sorted.html\">(order by CMI)</a></th><th>totalloc</th>"
                        + "<th>totallom</th><th>avgloc</th>" + "<th>avglom</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());
            } else {
                // sorted report
                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>file "
                        + "<a href=\"mi.html\">(back)</a></th><th>totalloc</th>"
                        + "<th>totallom</th><th>avgloc</th>" + "<th>avglom</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());
            }
            for (int i = 0; i < pmi.getFiles().size(); i++) {
                FileMetrics fm = (FileMetrics) pmi.getFiles().get(i);
                if (fm.getFileOrder() < 0) {
                    fm.setFileOrder(i);
                }
                // cmi<130 color="red"
                if (fm.getCmi() < GOODCMI) {
                    os.write(("<tr><td>[<a href=\"" + fileName + "files/" + fm.getFileOrder()
                            + ".html\"><font color=\"red\">" + fm.getFilePath() + "</font></a>]</td><td>"
                            + fm.getLoc() + "</td><td>" + fm.getLom() + "</td><td>"
                            + FMT.format(fm.getAvgLoc()) + "</td><td>" + FMT.format(fm.getAvgLom())
                            + "</td><td>" + FMT.format(fm.getAvgHalsteadVolume()) + "</td><td>"
                            + FMT.format(fm.getAvgCcVolume()) + "</td><td>" + FMT.format(fm.getMi())
                            + "</td><td>" + FMT.format(fm.getCmi()) + "</td></tr>").getBytes());
                } else if (!isBad) {
                    os.write(("<tr><td>[<a href=\"" + fileName + "files/" + fm.getFileOrder() + ".html\">"
                            + fm.getFilePath() + "</a>]</td><td>" + fm.getLoc() + "</td><td>" + fm.getLom()
                            + "</td><td>" + FMT.format(fm.getAvgLoc()) + "</td><td>"
                            + FMT.format(fm.getAvgLom()) + "</td><td>"
                            + FMT.format(fm.getAvgHalsteadVolume()) + "</td><td>"
                            + FMT.format(fm.getAvgCcVolume()) + "</td><td>" + FMT.format(fm.getMi())
                            + "</td><td>" + FMT.format(fm.getCmi()) + "</td></tr>").getBytes());
                }
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeFunctionDetailTable(int fileNum, OutputStream os, FileMetrics fm, String fileName) {
        try {
            if ("mi".equals(fileName)) {
                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>function <a href=\"../sortedfiles/"
                        + fileNum
                        + ".html\">(order by CMI)</th>"
                        + "<th>totalloc</th><th>totallom</th><th>hn1</th>"
                        + "<th>hn2</th><th>hN1</th><th>hN2</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());
            } else {
                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>function <a href=\"../mifiles/"
                        + fileNum + ".html\">(back)</th>" + "<th>totalloc</th><th>totallom</th><th>hn1</th>"
                        + "<th>hn2</th><th>hN1</th><th>hN2</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());
            }
            if ("sorted".equals(fileName)) {
                fm.sortFiles();
            }
            for (int j = 0; j < fm.getFunctions().size(); j++) {
                FunctionMetrics ffm = (FunctionMetrics) fm.getFunctions().get(j);
                // cmi<130 color="red"
                if (ffm.getCmi() < GOODCMI) {
                    os.write(("<tr><td><font color=\"red\">" + ffm.getFunctionName() + "</font></td><td>"
                            + ffm.getLoc() + "</td><td>" + ffm.getLom() + "</td><td>" + ffm.getHn1()
                            + "</td><td>" + ffm.getHn2() + "</td><td>" + ffm.gethN1() + "</td><td>"
                            + ffm.gethN2() + "</td><td>" + FMT.format(ffm.getAvgHalsteadVolume())
                            + "</td><td>" + FMT.format(ffm.getAvgCcVolume()) + "</td><td>"
                            + FMT.format(ffm.getMi()) + "</td><td>" + FMT.format(ffm.getCmi()) + "</td></tr>")
                            .getBytes());
                } else {
                    os.write(("<tr><td><font color=\"blue\">" + ffm.getFunctionName() + "</font></td><td>"
                            + ffm.getLoc() + "</td><td>" + ffm.getLom() + "</td><td>" + ffm.getHn1()
                            + "</td><td>" + ffm.getHn2() + "</td><td>" + ffm.gethN1() + "</td><td>"
                            + ffm.gethN2() + "</td><td>" + FMT.format(ffm.getAvgHalsteadVolume())
                            + "</td><td>" + FMT.format(ffm.getAvgCcVolume()) + "</td><td>"
                            + FMT.format(ffm.getMi()) + "</td><td>" + FMT.format(ffm.getCmi()) + "</td></tr>")
                            .getBytes());
                }
            }

        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeSingleFileSummaryTable(OutputStream os, FileMetrics fm, String fileName) {
        try {
            os.write("FILE SUMMARY".getBytes());

            os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>name</th>"
                    + "<th>totalloc</th><th>totallom</th><th>avgloc</th>"
                    + "<th>avglom</th><th>avghalsteadvolume</th><th>avgcyclomaticcomplexity</th>"
                    + "<th>mi</th><th>miwithcomment</th></tr>").getBytes());

            if (fm.getCmi() < GOODCMI) {
                os.write(("<tr><td>[<a href=\"../" + fileName + ".html\"><font color=\"red\">"
                        + fm.getFilePath() + "</font></a>]</td><td>" + fm.getLoc() + "</td><td>"
                        + fm.getLom() + "</td><td>" + FMT.format(fm.getAvgLoc()) + "</td><td>"
                        + FMT.format(fm.getAvgLom()) + "</td><td>" + FMT.format(fm.getAvgHalsteadVolume())
                        + "</td><td>" + FMT.format(fm.getAvgCcVolume()) + "</td><td>"
                        + FMT.format(fm.getMi()) + "</td><td>" + FMT.format(fm.getCmi()) + "</td></tr></table>")
                        .getBytes());
            } else {
                os.write(("<tr><td>[<a href=\"../" + fileName + ".html\">" + fm.getFilePath()
                        + "</a>]</td><td>" + fm.getLoc() + "</td><td>" + fm.getLom() + "</td><td>"
                        + FMT.format(fm.getAvgLoc()) + "</td><td>" + FMT.format(fm.getAvgLom()) + "</td><td>"
                        + FMT.format(fm.getAvgHalsteadVolume()) + "</td><td>"
                        + FMT.format(fm.getAvgCcVolume()) + "</td><td>" + FMT.format(fm.getMi())
                        + "</td><td>" + FMT.format(fm.getCmi()) + "</td></tr></table>").getBytes());
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public void writeBadReport(String fileName) {
        try {
            String reportFile = this.reportPath + File.separator + "bad.html";
            OutputStream os = new FileOutputStream(reportFile);

            writeHeaderInHTML(os);
            os.write(("<body><p><A name=\"top\"></A></p><table class=\"hdft\""
                    + " cellspacing=\"0\" width=\"100%\"><tr><th class=\"tl\">" + "quality system</th></tr>"
                    + "<tr><td class=\"nv\">[<a href=\"mi.html\">project</a>]" + "</td></tr></table>\n")
                    .getBytes());
            for (int i = 0; i < pmi.getFiles().size(); i++) {
                writeSinglePart(os, pmi.getFiles().get(i));
            }

            os.write("</body>".getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    private void writeSinglePart(OutputStream os, FileMetrics fm) {
        try {

            os.write(("<b><font color=\"black\">" + fm.getFilePath() + "</font></b><br>").getBytes());

            os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>Bad Functions"
                    + "</th><th>totalloc</th><th>totallom</th><th>hn1</th>"
                    + "<th>hn2</th><th>hN1</th><th>hN2</th><th>avghalsteadvolume</th>"
                    + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                    .getBytes());

            for (int i = 0; i < fm.getFunctions().size(); i++) {
                FunctionMetrics ffm = (FunctionMetrics) fm.getFunctions().get(i);
                if (ffm.getCmi() < GOODCMI) {
                    os.write(("<tr><td><font color=\"red\">" + ffm.getFunctionName() + "</font></td><td>"
                            + ffm.getLoc() + "</td><td>" + ffm.getLom() + "</td><td>" + ffm.getHn1()
                            + "</td><td>" + ffm.getHn2() + "</td><td>" + ffm.gethN1() + "</td><td>"
                            + ffm.gethN2() + "</td><td>" + FMT.format(ffm.getAvgHalsteadVolume())
                            + "</td><td>" + FMT.format(ffm.getAvgCcVolume()) + "</td><td>"
                            + FMT.format(ffm.getMi()) + "</td><td>" + FMT.format(ffm.getCmi()) + "</td></tr>")
                            .getBytes());
                }
            }
            os.write("</table>".getBytes());
            os.write("<a href=#top>back to top</a><br>".getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write html report");
        }
    }

    public List<FunctionMetricsAdd> getTotalSortedFunctions() {
        List<FunctionMetricsAdd> totalFunctions = new ArrayList<FunctionMetricsAdd>();
        for (int i = 0; i < pmi.getFiles().size(); i++) {
            FileMetrics temp = pmi.getFiles().get(i);
            for (int j = 0; j < temp.getFunctions().size(); j++) {
                totalFunctions.add(new FunctionMetricsAdd(temp.getFunctions().get(j), temp.getFilePath()));
            }
        }
        for (int i = 0; i < totalFunctions.size(); i++) {
            for (int j = i + 1; j < totalFunctions.size(); j++) {
                if (totalFunctions.get(j).getFM().getCmi() < totalFunctions.get(i).getFM().getCmi()) {
                    FunctionMetricsAdd temp = totalFunctions.get(i);
                    totalFunctions.set(i, totalFunctions.get(j));
                    totalFunctions.set(j, temp);
                }
            }
        }
        return totalFunctions;
    }

    public void writeWorstFunctionsReport(List<FunctionMetricsAdd> fmaList, int funNum) {
        try {
            String reportFile = this.reportPath + File.separator + "worst.html";
            OutputStream os = new FileOutputStream(reportFile);

            writeHeaderInHTML(os);
            os.write(("<body><p><A name=\"top\"></A></p><table class=\"hdft\""
                    + " cellspacing=\"0\" width=\"100%\"><tr><th class=\"tl\">" + "quality system</th></tr>"
                    + "<tr><td class=\"nv\">[<a href=\"mi.html\">project</a>]" + "</td></tr></table>\n")
                    .getBytes());
            int actualNum = funNum;
            if (fmaList.size() <= funNum) {
                actualNum = fmaList.size();
            }
            for (int i = 0; i < actualNum; i++) {
                FunctionMetricsAdd fma = fmaList.get(i);

                os.write(("<table cellspacing=\"0\" width=\"100%\"><tr><th>Bad Functions"
                        + "</th><th>totalloc</th><th>totallom</th><th>hn1</th>"
                        + "<th>hn2</th><th>hN1</th><th>hN2</th><th>avghalsteadvolume</th>"
                        + "<th>avgcyclomaticcomplexity</th><th>mi</th>" + "<th>miwithcomment</th></tr>")
                        .getBytes());

                os.write(("<tr><td><font color=\"red\">" + fma.getFilePath() + "  :  "
                        + fma.getFM().getFunctionName() + "</font></td><td>" + fma.getFM().getLoc()
                        + "</td><td>" + fma.getFM().getLom() + "</td><td>" + fma.getFM().getHn1()
                        + "</td><td>" + fma.getFM().getHn2() + "</td><td>" + fma.getFM().gethN1()
                        + "</td><td>" + fma.getFM().gethN2() + "</td><td>"
                        + FMT.format(fma.getFM().getAvgHalsteadVolume()) + "</td><td>"
                        + FMT.format(fma.getFM().getAvgCcVolume()) + "</td><td>"
                        + FMT.format(fma.getFM().getMi()) + "</td><td>" + FMT.format(fma.getFM().getCmi())
                        + "</td></tr>")
                        .getBytes());
                os.write("</table>".getBytes());
                os.write("<a href=#top>back to top</a><br>".getBytes());
            }

            os.write("</body>".getBytes());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write worst functions html report");
        }
    }
}
