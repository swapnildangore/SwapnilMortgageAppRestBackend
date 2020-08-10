/**
 * 
 */
package com.mymortgagaeapp.data.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Swapnil Dangore
 *
 */
public class MortgageApplication implements Comparable<MortgageApplication>{

	
	@NotNull
	String mortgageId;
	@NotNull
	String version;
	@NotNull
	String offerId;
	@NotNull
	String productId;
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	Date offerDate;
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	Date createdDate;
	boolean offerExpired;
	
	/**
	 * @return the mortgageId
	 */
	public String getMortgageId() {
		return mortgageId;
	}
	/**
	 * @param mortgageId the mortgageId to set
	 */
	public void setMortgageId(String mortgageId) {
		this.mortgageId = mortgageId;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}
	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the offerDate
	 */
	public Date getOfferDate() {
		return offerDate;
	}
	/**
	 * @param offerDate the offerDate to set
	 */
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the offerExpired
	 */
	public boolean isOfferExpired() {
		return offerExpired;
	}
	/**
	 * @param offerExpired the offerExpired to set
	 */
	public void setOfferExpired(boolean offerExpired) {
		this.offerExpired = offerExpired;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mortgageId == null) ? 0 : mortgageId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MortgageApplication other = (MortgageApplication) obj;
		if (mortgageId == null) {
			if (other.mortgageId != null)
				return false;
		} else if (!mortgageId.equals(other.mortgageId))
			return false;
		return true;
	}
	@Override
	public int compareTo(MortgageApplication other) {
		return this.createdDate.compareTo(other.createdDate);
	}
	
}
