package edu.csus.csc131.euc.model.data;
import edu.csus.csc131.euc.model.data.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfileTest {

	@Test
	void test() {
		Profile p = new Profile(0);
		p.getTotalCostByDay(0);
		p.setProfileID(0);
		p.getDay("");
		p.getTotalUsageByDay(0);
		Day daySummer = new Day("Jan 1, 2020", true);
		Day dayNonSummer = new Day("August 1, 2020", false);
		p.addDay(daySummer);
		p.addDay(dayNonSummer);
		p.getDay("Jan 1, 2020").setUsage(1, 0, 24);
		p.getDay("August 1, 2020").setUsage(1, 0, 24);
		System.out.println("Total Cost: " + p.calculateKWH());
		System.out.println("Total Usage: " + p.getTotalUsage());
		System.out.println("Total Cost first day: " + p.getTotalCostByDay(0));
		System.out.println("Total Cost second day: " + p.getTotalCostByDay(1));
		System.out.println("Total Usage first day: " + p.getTotalUsageByDay(0));
		System.out.println("Total Usage second day: " + p.getTotalUsageByDay(1));
		
		System.out.println("Peak Cost first day: " + p.getCostPeakNonSummer(0));
		System.out.println("OffPeak Cost first day: " + p.getCostOffPeakNonSummer(0));

		System.out.println("Peak Cost second day: " + p.getCostPeakSummer(1));
		System.out.println("OffPeak Cost second day: " + p.getCostOffPeakSummer(1));
		System.out.println("MidPeak Cost second day: " + p.getCostMidPeakSummer(1));
		
		System.out.println("Peak Usage first day: " + p.getUsagePeakNonSummer(0));
		System.out.println("OffPeak Usage first day: " + p.getUsageOffPeakNonSummer(0));

		System.out.println("Peak Usage second day: " + p.getUsagePeakSummer(1));
		System.out.println("OffPeak Usage second day: " + p.getUsageOffPeakSummer(1));
		System.out.println("MidPeak Usage second day: " + p.getUsageMidPeakSummer(1));
		
		p.dumpValues();
		
		p.deleteRecord("Jan 1, 2020", 0);
		p.resetToNewRates();
		p.resetDefault();
		Rates r = new Rates(true);
		Profile.setSummerRates(r);
		Rates r2 = new Rates(false);
		Profile.setNonSummerRates(r2);
		p.setProfileUnit("kWH");
		p.setProfileSiteTimeZoneID("1");
		p.getProfileID();
		p.getDays();
		p.getSummerRates();
		p.getNonSummerRates();
		p.setSummerRates(0, 0);
		p.setNonSummerRates(0, 0);
		p.getNonSummerRates();
		p.getTotalCost();
		p.setProfileUnit();
		p.setProfileSiteTimeZoneID();
		
		
	}

}
