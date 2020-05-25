package com.dongzhe.project.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class BusDailyDO implements Serializable {
    private Long id;

    /**
     * base_share.id
     */
    private Long shareId;

    /**
     * 股票代码
     */
    private String code;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 开盘价
     */
    private Long startPrice;

    /**
     * 收盘价
     */
    private Long stopPrice;

    /**
     * 最高价
     */
    private Long maxPrice;

    /**
     * 最低价
     */
    private Long minPrice;

    /**
     * 买一价
     */
    private Long buy1;

    /**
     * 卖一价
     */
    private Long sell1;

    /**
     * 成交的股票数
     */
    private Integer dealCount;

    /**
     * 成交金额
     */
    private Long dealMoney;

    /**
     * 买一数量
     */
    private Integer buy1Count;

    /**
     * 买一报价
     */
    private Long buy1Price;

    /**
     * 买二数量
     */
    private Integer buy2Count;

    /**
     * 买二报价
     */
    private Long buy2Price;

    /**
     * 买三数量
     */
    private Integer buy3Count;

    /**
     * 买三报价
     */
    private Long buy3Price;

    /**
     * 买四数量
     */
    private Integer buy4Count;

    /**
     * 买四报价
     */
    private Long buy4Price;

    /**
     * 买五数量
     */
    private Integer buy5Count;

    /**
     * 买五报价
     */
    private Long buy5Price;

    /**
     * 卖一数量
     */
    private Integer sell1Count;

    /**
     * 卖一报价
     */
    private Long sell1Price;

    /**
     * 卖二数量
     */
    private Integer sell2Count;

    /**
     * 卖二报价
     */
    private Long sell2Price;

    /**
     * 卖三数量
     */
    private Integer sell3Count;

    /**
     * 卖三报价
     */
    private Long sell3Price;

    /**
     * 卖四数量
     */
    private Integer sell4Count;

    /**
     * 卖四报价
     */
    private Long sell4Price;

    /**
     * 卖五数量
     */
    private Integer sell5Count;

    /**
     * 卖五报价
     */
    private Long sell5Price;

    /**
     * 交易日期
     */
    private Date dealDay;

    /**
     * 交易时间
     */
    private Date dealTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Long stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getBuy1() {
        return buy1;
    }

    public void setBuy1(Long buy1) {
        this.buy1 = buy1;
    }

    public Long getSell1() {
        return sell1;
    }

    public void setSell1(Long sell1) {
        this.sell1 = sell1;
    }

    public Integer getDealCount() {
        return dealCount;
    }

    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
    }

    public Long getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(Long dealMoney) {
        this.dealMoney = dealMoney;
    }

    public Integer getBuy1Count() {
        return buy1Count;
    }

    public void setBuy1Count(Integer buy1Count) {
        this.buy1Count = buy1Count;
    }

    public Long getBuy1Price() {
        return buy1Price;
    }

    public void setBuy1Price(Long buy1Price) {
        this.buy1Price = buy1Price;
    }

    public Integer getBuy2Count() {
        return buy2Count;
    }

    public void setBuy2Count(Integer buy2Count) {
        this.buy2Count = buy2Count;
    }

    public Long getBuy2Price() {
        return buy2Price;
    }

    public void setBuy2Price(Long buy2Price) {
        this.buy2Price = buy2Price;
    }

    public Integer getBuy3Count() {
        return buy3Count;
    }

    public void setBuy3Count(Integer buy3Count) {
        this.buy3Count = buy3Count;
    }

    public Long getBuy3Price() {
        return buy3Price;
    }

    public void setBuy3Price(Long buy3Price) {
        this.buy3Price = buy3Price;
    }

    public Integer getBuy4Count() {
        return buy4Count;
    }

    public void setBuy4Count(Integer buy4Count) {
        this.buy4Count = buy4Count;
    }

    public Long getBuy4Price() {
        return buy4Price;
    }

    public void setBuy4Price(Long buy4Price) {
        this.buy4Price = buy4Price;
    }

    public Integer getBuy5Count() {
        return buy5Count;
    }

    public void setBuy5Count(Integer buy5Count) {
        this.buy5Count = buy5Count;
    }

    public Long getBuy5Price() {
        return buy5Price;
    }

    public void setBuy5Price(Long buy5Price) {
        this.buy5Price = buy5Price;
    }

    public Integer getSell1Count() {
        return sell1Count;
    }

    public void setSell1Count(Integer sell1Count) {
        this.sell1Count = sell1Count;
    }

    public Long getSell1Price() {
        return sell1Price;
    }

    public void setSell1Price(Long sell1Price) {
        this.sell1Price = sell1Price;
    }

    public Integer getSell2Count() {
        return sell2Count;
    }

    public void setSell2Count(Integer sell2Count) {
        this.sell2Count = sell2Count;
    }

    public Long getSell2Price() {
        return sell2Price;
    }

    public void setSell2Price(Long sell2Price) {
        this.sell2Price = sell2Price;
    }

    public Integer getSell3Count() {
        return sell3Count;
    }

    public void setSell3Count(Integer sell3Count) {
        this.sell3Count = sell3Count;
    }

    public Long getSell3Price() {
        return sell3Price;
    }

    public void setSell3Price(Long sell3Price) {
        this.sell3Price = sell3Price;
    }

    public Integer getSell4Count() {
        return sell4Count;
    }

    public void setSell4Count(Integer sell4Count) {
        this.sell4Count = sell4Count;
    }

    public Long getSell4Price() {
        return sell4Price;
    }

    public void setSell4Price(Long sell4Price) {
        this.sell4Price = sell4Price;
    }

    public Integer getSell5Count() {
        return sell5Count;
    }

    public void setSell5Count(Integer sell5Count) {
        this.sell5Count = sell5Count;
    }

    public Long getSell5Price() {
        return sell5Price;
    }

    public void setSell5Price(Long sell5Price) {
        this.sell5Price = sell5Price;
    }

    public Date getDealDay() {
        return dealDay;
    }

    public void setDealDay(Date dealDay) {
        this.dealDay = dealDay;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BusDailyDO other = (BusDailyDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShareId() == null ? other.getShareId() == null : this.getShareId().equals(other.getShareId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStartPrice() == null ? other.getStartPrice() == null : this.getStartPrice().equals(other.getStartPrice()))
            && (this.getStopPrice() == null ? other.getStopPrice() == null : this.getStopPrice().equals(other.getStopPrice()))
            && (this.getMaxPrice() == null ? other.getMaxPrice() == null : this.getMaxPrice().equals(other.getMaxPrice()))
            && (this.getMinPrice() == null ? other.getMinPrice() == null : this.getMinPrice().equals(other.getMinPrice()))
            && (this.getBuy1() == null ? other.getBuy1() == null : this.getBuy1().equals(other.getBuy1()))
            && (this.getSell1() == null ? other.getSell1() == null : this.getSell1().equals(other.getSell1()))
            && (this.getDealCount() == null ? other.getDealCount() == null : this.getDealCount().equals(other.getDealCount()))
            && (this.getDealMoney() == null ? other.getDealMoney() == null : this.getDealMoney().equals(other.getDealMoney()))
            && (this.getBuy1Count() == null ? other.getBuy1Count() == null : this.getBuy1Count().equals(other.getBuy1Count()))
            && (this.getBuy1Price() == null ? other.getBuy1Price() == null : this.getBuy1Price().equals(other.getBuy1Price()))
            && (this.getBuy2Count() == null ? other.getBuy2Count() == null : this.getBuy2Count().equals(other.getBuy2Count()))
            && (this.getBuy2Price() == null ? other.getBuy2Price() == null : this.getBuy2Price().equals(other.getBuy2Price()))
            && (this.getBuy3Count() == null ? other.getBuy3Count() == null : this.getBuy3Count().equals(other.getBuy3Count()))
            && (this.getBuy3Price() == null ? other.getBuy3Price() == null : this.getBuy3Price().equals(other.getBuy3Price()))
            && (this.getBuy4Count() == null ? other.getBuy4Count() == null : this.getBuy4Count().equals(other.getBuy4Count()))
            && (this.getBuy4Price() == null ? other.getBuy4Price() == null : this.getBuy4Price().equals(other.getBuy4Price()))
            && (this.getBuy5Count() == null ? other.getBuy5Count() == null : this.getBuy5Count().equals(other.getBuy5Count()))
            && (this.getBuy5Price() == null ? other.getBuy5Price() == null : this.getBuy5Price().equals(other.getBuy5Price()))
            && (this.getSell1Count() == null ? other.getSell1Count() == null : this.getSell1Count().equals(other.getSell1Count()))
            && (this.getSell1Price() == null ? other.getSell1Price() == null : this.getSell1Price().equals(other.getSell1Price()))
            && (this.getSell2Count() == null ? other.getSell2Count() == null : this.getSell2Count().equals(other.getSell2Count()))
            && (this.getSell2Price() == null ? other.getSell2Price() == null : this.getSell2Price().equals(other.getSell2Price()))
            && (this.getSell3Count() == null ? other.getSell3Count() == null : this.getSell3Count().equals(other.getSell3Count()))
            && (this.getSell3Price() == null ? other.getSell3Price() == null : this.getSell3Price().equals(other.getSell3Price()))
            && (this.getSell4Count() == null ? other.getSell4Count() == null : this.getSell4Count().equals(other.getSell4Count()))
            && (this.getSell4Price() == null ? other.getSell4Price() == null : this.getSell4Price().equals(other.getSell4Price()))
            && (this.getSell5Count() == null ? other.getSell5Count() == null : this.getSell5Count().equals(other.getSell5Count()))
            && (this.getSell5Price() == null ? other.getSell5Price() == null : this.getSell5Price().equals(other.getSell5Price()))
            && (this.getDealDay() == null ? other.getDealDay() == null : this.getDealDay().equals(other.getDealDay()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShareId() == null) ? 0 : getShareId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStartPrice() == null) ? 0 : getStartPrice().hashCode());
        result = prime * result + ((getStopPrice() == null) ? 0 : getStopPrice().hashCode());
        result = prime * result + ((getMaxPrice() == null) ? 0 : getMaxPrice().hashCode());
        result = prime * result + ((getMinPrice() == null) ? 0 : getMinPrice().hashCode());
        result = prime * result + ((getBuy1() == null) ? 0 : getBuy1().hashCode());
        result = prime * result + ((getSell1() == null) ? 0 : getSell1().hashCode());
        result = prime * result + ((getDealCount() == null) ? 0 : getDealCount().hashCode());
        result = prime * result + ((getDealMoney() == null) ? 0 : getDealMoney().hashCode());
        result = prime * result + ((getBuy1Count() == null) ? 0 : getBuy1Count().hashCode());
        result = prime * result + ((getBuy1Price() == null) ? 0 : getBuy1Price().hashCode());
        result = prime * result + ((getBuy2Count() == null) ? 0 : getBuy2Count().hashCode());
        result = prime * result + ((getBuy2Price() == null) ? 0 : getBuy2Price().hashCode());
        result = prime * result + ((getBuy3Count() == null) ? 0 : getBuy3Count().hashCode());
        result = prime * result + ((getBuy3Price() == null) ? 0 : getBuy3Price().hashCode());
        result = prime * result + ((getBuy4Count() == null) ? 0 : getBuy4Count().hashCode());
        result = prime * result + ((getBuy4Price() == null) ? 0 : getBuy4Price().hashCode());
        result = prime * result + ((getBuy5Count() == null) ? 0 : getBuy5Count().hashCode());
        result = prime * result + ((getBuy5Price() == null) ? 0 : getBuy5Price().hashCode());
        result = prime * result + ((getSell1Count() == null) ? 0 : getSell1Count().hashCode());
        result = prime * result + ((getSell1Price() == null) ? 0 : getSell1Price().hashCode());
        result = prime * result + ((getSell2Count() == null) ? 0 : getSell2Count().hashCode());
        result = prime * result + ((getSell2Price() == null) ? 0 : getSell2Price().hashCode());
        result = prime * result + ((getSell3Count() == null) ? 0 : getSell3Count().hashCode());
        result = prime * result + ((getSell3Price() == null) ? 0 : getSell3Price().hashCode());
        result = prime * result + ((getSell4Count() == null) ? 0 : getSell4Count().hashCode());
        result = prime * result + ((getSell4Price() == null) ? 0 : getSell4Price().hashCode());
        result = prime * result + ((getSell5Count() == null) ? 0 : getSell5Count().hashCode());
        result = prime * result + ((getSell5Price() == null) ? 0 : getSell5Price().hashCode());
        result = prime * result + ((getDealDay() == null) ? 0 : getDealDay().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shareId=").append(shareId);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", startPrice=").append(startPrice);
        sb.append(", stopPrice=").append(stopPrice);
        sb.append(", maxPrice=").append(maxPrice);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", buy1=").append(buy1);
        sb.append(", sell1=").append(sell1);
        sb.append(", dealCount=").append(dealCount);
        sb.append(", dealMoney=").append(dealMoney);
        sb.append(", buy1Count=").append(buy1Count);
        sb.append(", buy1Price=").append(buy1Price);
        sb.append(", buy2Count=").append(buy2Count);
        sb.append(", buy2Price=").append(buy2Price);
        sb.append(", buy3Count=").append(buy3Count);
        sb.append(", buy3Price=").append(buy3Price);
        sb.append(", buy4Count=").append(buy4Count);
        sb.append(", buy4Price=").append(buy4Price);
        sb.append(", buy5Count=").append(buy5Count);
        sb.append(", buy5Price=").append(buy5Price);
        sb.append(", sell1Count=").append(sell1Count);
        sb.append(", sell1Price=").append(sell1Price);
        sb.append(", sell2Count=").append(sell2Count);
        sb.append(", sell2Price=").append(sell2Price);
        sb.append(", sell3Count=").append(sell3Count);
        sb.append(", sell3Price=").append(sell3Price);
        sb.append(", sell4Count=").append(sell4Count);
        sb.append(", sell4Price=").append(sell4Price);
        sb.append(", sell5Count=").append(sell5Count);
        sb.append(", sell5Price=").append(sell5Price);
        sb.append(", dealDay=").append(dealDay);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}