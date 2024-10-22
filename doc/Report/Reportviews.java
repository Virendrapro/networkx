// ReportViews.java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Sample Report class for demonstration
class Report {
    private int id;
    private String name;

    public Report(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// ReportViews class that contains methods to manipulate reports
public class ReportViews {
    public Report getReport(int reportId) {
        if (reportId <= 0) {
            return null; // Simulating no report found
        }
        return new Report(reportId, "Sample Report");
    }

    public boolean createReport(Report report) {
        if (report == null) {
            return false; // Prevent creating a null report
        }
        // Logic to create a new report
        return true; // Simulating successful creation
    }

    public boolean deleteReport(int reportId) {
        if (reportId <= 0) {
            return false; // Prevent deleting an invalid report
        }
        // Logic to delete a report
        return true; // Simulating successful deletion
    }

    // Unit tests for the ReportViews class
    public static class ReportViewsTest {

        @Test
        public void testGetReportSuccess() {
            ReportViews reportViews = new ReportViews();
            Report result = reportViews.getReport(1);
            assertNotNull(result);
            assertEquals(1, result.getId());
            assertEquals("Sample Report", result.getName());
        }

        @Test
        public void testCreateReportSuccess() {
            ReportViews reportViews = new ReportViews();
            Report report = new Report(1, "New Report");
            boolean result = reportViews.createReport(report);
            assertTrue(result);
        }

        @Test
        public void testDeleteReportSuccess() {
            ReportViews reportViews = new ReportViews();
            boolean result = reportViews.deleteReport(1);
            assertTrue(result);
        }

        @Test
        public void testGetReportWithInvalidId() {
            ReportViews reportViews = new ReportViews();
            Report result = reportViews.getReport(-1);
            assertNull(result, "Report should be null for invalid ID");
        }

        @Test
        public void testCreateReportWithNull() {
            ReportViews reportViews = new ReportViews();
            boolean result = reportViews.createReport(null);
            assertFalse(result, "Create report should return false for null input");
        }

        @Test
        public void testDeleteReportWithInvalidId() {
            ReportViews reportViews = new ReportViews();
            boolean result = reportViews.deleteReport(-1);
            assertFalse(result, "Delete should return false for invalid ID");
        }
    }
}
