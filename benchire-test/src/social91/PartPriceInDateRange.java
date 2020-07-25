package social91;

import java.util.Date;

public class PartPriceInDateRange {
	private int partId;
	private Date startDate;
	private Date endDate;
	private Double price;
	public PartPriceInDateRange() {
	}
	public PartPriceInDateRange(int partId, Date startDate, Date endDate, Double price) {
		super();
		this.partId = partId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return partId + " "+startDate.getTime()+" "+ endDate.getTime()+" "+price;
	}
}
