package social91;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ConfigurationClass {
	Set<PartPriceInDateRange> pricingTable = new HashSet<>();
	Set<Component> components = new HashSet<>();
	Set<Part> parts = new HashSet<>();

	public void configureData() throws ParseException {
		Component frame = new Component(1, "Frame");
		Component handleBar = new Component(2, "HandleBar");
		Component seat = new Component(3, "Seat");
		Component wheel = new Component(4, "Wheel");
		Component chain = new Component(5, "Chain");

		components.add(frame);
		components.add(handleBar);
		components.add(seat);
		components.add(wheel);
		components.add(chain);

		Part ironFrame = new Part(1, "IronFrame", frame, "Atlas");
		Part steelFrame = new Part(2, "steelFrame", frame, "Hero");
		Part fiberFrame = new Part(3, "FiberFrame", frame, "Atlas");

		Part ironHandle = new Part(4, "IronHandle", handleBar, "Hero");
		Part steelHandle = new Part(5, "SteelHandle", handleBar, "Atlas");

		Part leatherSeat = new Part(6, "LeatherSeat", seat, "Astute");
		Part plasticSeat = new Part(7, "PlasticSeat", seat, "Ergon");
		Part fiberSeat = new Part(8, "FiberSeat", seat, "Hero");

		Part tyre = new Part(9, "Tyre", wheel, "Hero");
		Part tubeLessTyre = new Part(10, "TubeLessTyre", wheel, "Mrf");
		Part spoke = new Part(11, "Spoke", wheel, "Mrf");
		Part rim = new Part(12, "Rim", wheel, "Atlas");
		Part tube = new Part(13, "Tube", wheel, "Mrf");

		Part ironChain = new Part(14, "IronChain", chain, "Hero");

		parts.add(ironFrame);
		parts.add(steelFrame);
		parts.add(fiberFrame);
		parts.add(ironHandle);
		parts.add(steelHandle);
		parts.add(leatherSeat);
		parts.add(plasticSeat);
		parts.add(fiberSeat);
		parts.add(tyre);
		parts.add(tubeLessTyre);
		parts.add(spoke);
		parts.add(rim);
		parts.add(tube);
		parts.add(ironChain);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date startDate = format.parse("2000/0/01");
		Date endDate = format.parse("2019/11/31");

		pricingTable.add(new PartPriceInDateRange(1, startDate, endDate, 500.00));
		pricingTable.add(new PartPriceInDateRange(2, startDate, endDate, 550.00));
		pricingTable.add(new PartPriceInDateRange(3, startDate, endDate, 400.00));
		pricingTable.add(new PartPriceInDateRange(4, startDate, endDate, 200.00));
		pricingTable.add(new PartPriceInDateRange(5, startDate, endDate, 240.00));
		pricingTable.add(new PartPriceInDateRange(6, startDate, endDate, 70.00));
		pricingTable.add(new PartPriceInDateRange(7, startDate, endDate, 80.00));
		pricingTable.add(new PartPriceInDateRange(8, startDate, endDate, 75.00));
		pricingTable.add(new PartPriceInDateRange(9, startDate, endDate, 300.00));
		pricingTable.add(new PartPriceInDateRange(10, startDate, endDate, 400.00));
		pricingTable.add(new PartPriceInDateRange(11, startDate, endDate, 20.00));
		pricingTable.add(new PartPriceInDateRange(12, startDate, endDate, 150.00));
		pricingTable.add(new PartPriceInDateRange(13, startDate, endDate, 180.00));
		pricingTable.add(new PartPriceInDateRange(14, startDate, endDate, 220.00));

		Date startDate2 = format.parse("2020/01/01");
		Date endDate2 = format.parse("2025/11/31");
		pricingTable.add(new PartPriceInDateRange(1, startDate2, endDate2, 550.00));
		pricingTable.add(new PartPriceInDateRange(2, startDate2, endDate2, 580.00));
		pricingTable.add(new PartPriceInDateRange(3, startDate2, endDate2, 430.00));
		pricingTable.add(new PartPriceInDateRange(4, startDate2, endDate2, 220.00));
		pricingTable.add(new PartPriceInDateRange(5, startDate2, endDate2, 260.00));
		pricingTable.add(new PartPriceInDateRange(6, startDate2, endDate2, 90.00));
		pricingTable.add(new PartPriceInDateRange(7, startDate2, endDate2, 90.00));
		pricingTable.add(new PartPriceInDateRange(8, startDate2, endDate2, 85.00));
		pricingTable.add(new PartPriceInDateRange(9, startDate2, endDate2, 400.00));
		pricingTable.add(new PartPriceInDateRange(10, startDate2, endDate2, 420.00));
		pricingTable.add(new PartPriceInDateRange(11, startDate2, endDate2, 30.00));
		pricingTable.add(new PartPriceInDateRange(12, startDate2, endDate2, 100.00));
		pricingTable.add(new PartPriceInDateRange(13, startDate2, endDate2, 150.00));
		pricingTable.add(new PartPriceInDateRange(14, startDate, endDate, 260.00));

	}

	public double findPartsPriceOnDate(String singlePart, Date dateObj) {
		// TODO Auto-generated method stub
		Double price = 0.0;
		Optional<Part> partBool = parts.stream().filter(o -> o.getName().equals(singlePart)).findFirst();
		if (partBool.isPresent()) {
			Part partObj = partBool.get();
			for (PartPriceInDateRange pt : pricingTable) {
				if (pt.getPartId() == partObj.getId() && dateObj.after(pt.getStartDate())
						&& dateObj.before(pt.getEndDate())) {
					price = pt.getPrice();
					break;
				}
			}
		}
		return price;
	}

}
