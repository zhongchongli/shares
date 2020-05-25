package com.dongzhe.project.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BusDailyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BusDailyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNull() {
            addCriterion("share_id is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("share_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(Long value) {
            addCriterion("share_id =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(Long value) {
            addCriterion("share_id <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(Long value) {
            addCriterion("share_id >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(Long value) {
            addCriterion("share_id >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(Long value) {
            addCriterion("share_id <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(Long value) {
            addCriterion("share_id <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<Long> values) {
            addCriterion("share_id in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<Long> values) {
            addCriterion("share_id not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(Long value1, Long value2) {
            addCriterion("share_id between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(Long value1, Long value2) {
            addCriterion("share_id not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("start_price is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("start_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(Long value) {
            addCriterion("start_price =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(Long value) {
            addCriterion("start_price <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(Long value) {
            addCriterion("start_price >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("start_price >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(Long value) {
            addCriterion("start_price <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(Long value) {
            addCriterion("start_price <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(List<Long> values) {
            addCriterion("start_price in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(List<Long> values) {
            addCriterion("start_price not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(Long value1, Long value2) {
            addCriterion("start_price between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(Long value1, Long value2) {
            addCriterion("start_price not between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceIsNull() {
            addCriterion("stop_price is null");
            return (Criteria) this;
        }

        public Criteria andStopPriceIsNotNull() {
            addCriterion("stop_price is not null");
            return (Criteria) this;
        }

        public Criteria andStopPriceEqualTo(Long value) {
            addCriterion("stop_price =", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceNotEqualTo(Long value) {
            addCriterion("stop_price <>", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceGreaterThan(Long value) {
            addCriterion("stop_price >", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("stop_price >=", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceLessThan(Long value) {
            addCriterion("stop_price <", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceLessThanOrEqualTo(Long value) {
            addCriterion("stop_price <=", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceIn(List<Long> values) {
            addCriterion("stop_price in", values, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceNotIn(List<Long> values) {
            addCriterion("stop_price not in", values, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceBetween(Long value1, Long value2) {
            addCriterion("stop_price between", value1, value2, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceNotBetween(Long value1, Long value2) {
            addCriterion("stop_price not between", value1, value2, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNull() {
            addCriterion("max_price is null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNotNull() {
            addCriterion("max_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceEqualTo(Long value) {
            addCriterion("max_price =", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotEqualTo(Long value) {
            addCriterion("max_price <>", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThan(Long value) {
            addCriterion("max_price >", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("max_price >=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThan(Long value) {
            addCriterion("max_price <", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThanOrEqualTo(Long value) {
            addCriterion("max_price <=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIn(List<Long> values) {
            addCriterion("max_price in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotIn(List<Long> values) {
            addCriterion("max_price not in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceBetween(Long value1, Long value2) {
            addCriterion("max_price between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotBetween(Long value1, Long value2) {
            addCriterion("max_price not between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNull() {
            addCriterion("min_price is null");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNotNull() {
            addCriterion("min_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinPriceEqualTo(Long value) {
            addCriterion("min_price =", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotEqualTo(Long value) {
            addCriterion("min_price <>", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThan(Long value) {
            addCriterion("min_price >", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("min_price >=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThan(Long value) {
            addCriterion("min_price <", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThanOrEqualTo(Long value) {
            addCriterion("min_price <=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceIn(List<Long> values) {
            addCriterion("min_price in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotIn(List<Long> values) {
            addCriterion("min_price not in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceBetween(Long value1, Long value2) {
            addCriterion("min_price between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotBetween(Long value1, Long value2) {
            addCriterion("min_price not between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andBuy1IsNull() {
            addCriterion("buy1 is null");
            return (Criteria) this;
        }

        public Criteria andBuy1IsNotNull() {
            addCriterion("buy1 is not null");
            return (Criteria) this;
        }

        public Criteria andBuy1EqualTo(Long value) {
            addCriterion("buy1 =", value, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1NotEqualTo(Long value) {
            addCriterion("buy1 <>", value, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1GreaterThan(Long value) {
            addCriterion("buy1 >", value, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1GreaterThanOrEqualTo(Long value) {
            addCriterion("buy1 >=", value, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1LessThan(Long value) {
            addCriterion("buy1 <", value, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1LessThanOrEqualTo(Long value) {
            addCriterion("buy1 <=", value, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1In(List<Long> values) {
            addCriterion("buy1 in", values, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1NotIn(List<Long> values) {
            addCriterion("buy1 not in", values, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1Between(Long value1, Long value2) {
            addCriterion("buy1 between", value1, value2, "buy1");
            return (Criteria) this;
        }

        public Criteria andBuy1NotBetween(Long value1, Long value2) {
            addCriterion("buy1 not between", value1, value2, "buy1");
            return (Criteria) this;
        }

        public Criteria andSell1IsNull() {
            addCriterion("sell1 is null");
            return (Criteria) this;
        }

        public Criteria andSell1IsNotNull() {
            addCriterion("sell1 is not null");
            return (Criteria) this;
        }

        public Criteria andSell1EqualTo(Long value) {
            addCriterion("sell1 =", value, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1NotEqualTo(Long value) {
            addCriterion("sell1 <>", value, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1GreaterThan(Long value) {
            addCriterion("sell1 >", value, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1GreaterThanOrEqualTo(Long value) {
            addCriterion("sell1 >=", value, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1LessThan(Long value) {
            addCriterion("sell1 <", value, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1LessThanOrEqualTo(Long value) {
            addCriterion("sell1 <=", value, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1In(List<Long> values) {
            addCriterion("sell1 in", values, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1NotIn(List<Long> values) {
            addCriterion("sell1 not in", values, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1Between(Long value1, Long value2) {
            addCriterion("sell1 between", value1, value2, "sell1");
            return (Criteria) this;
        }

        public Criteria andSell1NotBetween(Long value1, Long value2) {
            addCriterion("sell1 not between", value1, value2, "sell1");
            return (Criteria) this;
        }

        public Criteria andDealCountIsNull() {
            addCriterion("deal_count is null");
            return (Criteria) this;
        }

        public Criteria andDealCountIsNotNull() {
            addCriterion("deal_count is not null");
            return (Criteria) this;
        }

        public Criteria andDealCountEqualTo(Integer value) {
            addCriterion("deal_count =", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotEqualTo(Integer value) {
            addCriterion("deal_count <>", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountGreaterThan(Integer value) {
            addCriterion("deal_count >", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_count >=", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountLessThan(Integer value) {
            addCriterion("deal_count <", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountLessThanOrEqualTo(Integer value) {
            addCriterion("deal_count <=", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountIn(List<Integer> values) {
            addCriterion("deal_count in", values, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotIn(List<Integer> values) {
            addCriterion("deal_count not in", values, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountBetween(Integer value1, Integer value2) {
            addCriterion("deal_count between", value1, value2, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_count not between", value1, value2, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealMoneyIsNull() {
            addCriterion("deal_money is null");
            return (Criteria) this;
        }

        public Criteria andDealMoneyIsNotNull() {
            addCriterion("deal_money is not null");
            return (Criteria) this;
        }

        public Criteria andDealMoneyEqualTo(Long value) {
            addCriterion("deal_money =", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyNotEqualTo(Long value) {
            addCriterion("deal_money <>", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyGreaterThan(Long value) {
            addCriterion("deal_money >", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("deal_money >=", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyLessThan(Long value) {
            addCriterion("deal_money <", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyLessThanOrEqualTo(Long value) {
            addCriterion("deal_money <=", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyIn(List<Long> values) {
            addCriterion("deal_money in", values, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyNotIn(List<Long> values) {
            addCriterion("deal_money not in", values, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyBetween(Long value1, Long value2) {
            addCriterion("deal_money between", value1, value2, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyNotBetween(Long value1, Long value2) {
            addCriterion("deal_money not between", value1, value2, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andBuy1CountIsNull() {
            addCriterion("buy1_count is null");
            return (Criteria) this;
        }

        public Criteria andBuy1CountIsNotNull() {
            addCriterion("buy1_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuy1CountEqualTo(Integer value) {
            addCriterion("buy1_count =", value, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountNotEqualTo(Integer value) {
            addCriterion("buy1_count <>", value, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountGreaterThan(Integer value) {
            addCriterion("buy1_count >", value, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy1_count >=", value, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountLessThan(Integer value) {
            addCriterion("buy1_count <", value, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountLessThanOrEqualTo(Integer value) {
            addCriterion("buy1_count <=", value, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountIn(List<Integer> values) {
            addCriterion("buy1_count in", values, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountNotIn(List<Integer> values) {
            addCriterion("buy1_count not in", values, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountBetween(Integer value1, Integer value2) {
            addCriterion("buy1_count between", value1, value2, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1CountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy1_count not between", value1, value2, "buy1Count");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceIsNull() {
            addCriterion("buy1_price is null");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceIsNotNull() {
            addCriterion("buy1_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceEqualTo(Long value) {
            addCriterion("buy1_price =", value, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceNotEqualTo(Long value) {
            addCriterion("buy1_price <>", value, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceGreaterThan(Long value) {
            addCriterion("buy1_price >", value, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("buy1_price >=", value, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceLessThan(Long value) {
            addCriterion("buy1_price <", value, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceLessThanOrEqualTo(Long value) {
            addCriterion("buy1_price <=", value, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceIn(List<Long> values) {
            addCriterion("buy1_price in", values, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceNotIn(List<Long> values) {
            addCriterion("buy1_price not in", values, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceBetween(Long value1, Long value2) {
            addCriterion("buy1_price between", value1, value2, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy1PriceNotBetween(Long value1, Long value2) {
            addCriterion("buy1_price not between", value1, value2, "buy1Price");
            return (Criteria) this;
        }

        public Criteria andBuy2CountIsNull() {
            addCriterion("buy2_count is null");
            return (Criteria) this;
        }

        public Criteria andBuy2CountIsNotNull() {
            addCriterion("buy2_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuy2CountEqualTo(Integer value) {
            addCriterion("buy2_count =", value, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountNotEqualTo(Integer value) {
            addCriterion("buy2_count <>", value, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountGreaterThan(Integer value) {
            addCriterion("buy2_count >", value, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy2_count >=", value, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountLessThan(Integer value) {
            addCriterion("buy2_count <", value, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountLessThanOrEqualTo(Integer value) {
            addCriterion("buy2_count <=", value, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountIn(List<Integer> values) {
            addCriterion("buy2_count in", values, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountNotIn(List<Integer> values) {
            addCriterion("buy2_count not in", values, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountBetween(Integer value1, Integer value2) {
            addCriterion("buy2_count between", value1, value2, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2CountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy2_count not between", value1, value2, "buy2Count");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceIsNull() {
            addCriterion("buy2_price is null");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceIsNotNull() {
            addCriterion("buy2_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceEqualTo(Long value) {
            addCriterion("buy2_price =", value, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceNotEqualTo(Long value) {
            addCriterion("buy2_price <>", value, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceGreaterThan(Long value) {
            addCriterion("buy2_price >", value, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("buy2_price >=", value, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceLessThan(Long value) {
            addCriterion("buy2_price <", value, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceLessThanOrEqualTo(Long value) {
            addCriterion("buy2_price <=", value, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceIn(List<Long> values) {
            addCriterion("buy2_price in", values, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceNotIn(List<Long> values) {
            addCriterion("buy2_price not in", values, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceBetween(Long value1, Long value2) {
            addCriterion("buy2_price between", value1, value2, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy2PriceNotBetween(Long value1, Long value2) {
            addCriterion("buy2_price not between", value1, value2, "buy2Price");
            return (Criteria) this;
        }

        public Criteria andBuy3CountIsNull() {
            addCriterion("buy3_count is null");
            return (Criteria) this;
        }

        public Criteria andBuy3CountIsNotNull() {
            addCriterion("buy3_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuy3CountEqualTo(Integer value) {
            addCriterion("buy3_count =", value, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountNotEqualTo(Integer value) {
            addCriterion("buy3_count <>", value, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountGreaterThan(Integer value) {
            addCriterion("buy3_count >", value, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy3_count >=", value, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountLessThan(Integer value) {
            addCriterion("buy3_count <", value, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountLessThanOrEqualTo(Integer value) {
            addCriterion("buy3_count <=", value, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountIn(List<Integer> values) {
            addCriterion("buy3_count in", values, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountNotIn(List<Integer> values) {
            addCriterion("buy3_count not in", values, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountBetween(Integer value1, Integer value2) {
            addCriterion("buy3_count between", value1, value2, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3CountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy3_count not between", value1, value2, "buy3Count");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceIsNull() {
            addCriterion("buy3_price is null");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceIsNotNull() {
            addCriterion("buy3_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceEqualTo(Long value) {
            addCriterion("buy3_price =", value, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceNotEqualTo(Long value) {
            addCriterion("buy3_price <>", value, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceGreaterThan(Long value) {
            addCriterion("buy3_price >", value, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("buy3_price >=", value, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceLessThan(Long value) {
            addCriterion("buy3_price <", value, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceLessThanOrEqualTo(Long value) {
            addCriterion("buy3_price <=", value, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceIn(List<Long> values) {
            addCriterion("buy3_price in", values, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceNotIn(List<Long> values) {
            addCriterion("buy3_price not in", values, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceBetween(Long value1, Long value2) {
            addCriterion("buy3_price between", value1, value2, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy3PriceNotBetween(Long value1, Long value2) {
            addCriterion("buy3_price not between", value1, value2, "buy3Price");
            return (Criteria) this;
        }

        public Criteria andBuy4CountIsNull() {
            addCriterion("buy4_count is null");
            return (Criteria) this;
        }

        public Criteria andBuy4CountIsNotNull() {
            addCriterion("buy4_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuy4CountEqualTo(Integer value) {
            addCriterion("buy4_count =", value, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountNotEqualTo(Integer value) {
            addCriterion("buy4_count <>", value, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountGreaterThan(Integer value) {
            addCriterion("buy4_count >", value, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy4_count >=", value, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountLessThan(Integer value) {
            addCriterion("buy4_count <", value, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountLessThanOrEqualTo(Integer value) {
            addCriterion("buy4_count <=", value, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountIn(List<Integer> values) {
            addCriterion("buy4_count in", values, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountNotIn(List<Integer> values) {
            addCriterion("buy4_count not in", values, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountBetween(Integer value1, Integer value2) {
            addCriterion("buy4_count between", value1, value2, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4CountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy4_count not between", value1, value2, "buy4Count");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceIsNull() {
            addCriterion("buy4_price is null");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceIsNotNull() {
            addCriterion("buy4_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceEqualTo(Long value) {
            addCriterion("buy4_price =", value, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceNotEqualTo(Long value) {
            addCriterion("buy4_price <>", value, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceGreaterThan(Long value) {
            addCriterion("buy4_price >", value, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("buy4_price >=", value, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceLessThan(Long value) {
            addCriterion("buy4_price <", value, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceLessThanOrEqualTo(Long value) {
            addCriterion("buy4_price <=", value, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceIn(List<Long> values) {
            addCriterion("buy4_price in", values, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceNotIn(List<Long> values) {
            addCriterion("buy4_price not in", values, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceBetween(Long value1, Long value2) {
            addCriterion("buy4_price between", value1, value2, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy4PriceNotBetween(Long value1, Long value2) {
            addCriterion("buy4_price not between", value1, value2, "buy4Price");
            return (Criteria) this;
        }

        public Criteria andBuy5CountIsNull() {
            addCriterion("buy5_count is null");
            return (Criteria) this;
        }

        public Criteria andBuy5CountIsNotNull() {
            addCriterion("buy5_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuy5CountEqualTo(Integer value) {
            addCriterion("buy5_count =", value, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountNotEqualTo(Integer value) {
            addCriterion("buy5_count <>", value, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountGreaterThan(Integer value) {
            addCriterion("buy5_count >", value, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy5_count >=", value, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountLessThan(Integer value) {
            addCriterion("buy5_count <", value, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountLessThanOrEqualTo(Integer value) {
            addCriterion("buy5_count <=", value, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountIn(List<Integer> values) {
            addCriterion("buy5_count in", values, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountNotIn(List<Integer> values) {
            addCriterion("buy5_count not in", values, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountBetween(Integer value1, Integer value2) {
            addCriterion("buy5_count between", value1, value2, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5CountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy5_count not between", value1, value2, "buy5Count");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceIsNull() {
            addCriterion("buy5_price is null");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceIsNotNull() {
            addCriterion("buy5_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceEqualTo(Long value) {
            addCriterion("buy5_price =", value, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceNotEqualTo(Long value) {
            addCriterion("buy5_price <>", value, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceGreaterThan(Long value) {
            addCriterion("buy5_price >", value, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("buy5_price >=", value, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceLessThan(Long value) {
            addCriterion("buy5_price <", value, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceLessThanOrEqualTo(Long value) {
            addCriterion("buy5_price <=", value, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceIn(List<Long> values) {
            addCriterion("buy5_price in", values, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceNotIn(List<Long> values) {
            addCriterion("buy5_price not in", values, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceBetween(Long value1, Long value2) {
            addCriterion("buy5_price between", value1, value2, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andBuy5PriceNotBetween(Long value1, Long value2) {
            addCriterion("buy5_price not between", value1, value2, "buy5Price");
            return (Criteria) this;
        }

        public Criteria andSell1CountIsNull() {
            addCriterion("sell1_count is null");
            return (Criteria) this;
        }

        public Criteria andSell1CountIsNotNull() {
            addCriterion("sell1_count is not null");
            return (Criteria) this;
        }

        public Criteria andSell1CountEqualTo(Integer value) {
            addCriterion("sell1_count =", value, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountNotEqualTo(Integer value) {
            addCriterion("sell1_count <>", value, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountGreaterThan(Integer value) {
            addCriterion("sell1_count >", value, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell1_count >=", value, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountLessThan(Integer value) {
            addCriterion("sell1_count <", value, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountLessThanOrEqualTo(Integer value) {
            addCriterion("sell1_count <=", value, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountIn(List<Integer> values) {
            addCriterion("sell1_count in", values, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountNotIn(List<Integer> values) {
            addCriterion("sell1_count not in", values, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountBetween(Integer value1, Integer value2) {
            addCriterion("sell1_count between", value1, value2, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1CountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell1_count not between", value1, value2, "sell1Count");
            return (Criteria) this;
        }

        public Criteria andSell1PriceIsNull() {
            addCriterion("sell1_price is null");
            return (Criteria) this;
        }

        public Criteria andSell1PriceIsNotNull() {
            addCriterion("sell1_price is not null");
            return (Criteria) this;
        }

        public Criteria andSell1PriceEqualTo(Long value) {
            addCriterion("sell1_price =", value, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceNotEqualTo(Long value) {
            addCriterion("sell1_price <>", value, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceGreaterThan(Long value) {
            addCriterion("sell1_price >", value, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sell1_price >=", value, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceLessThan(Long value) {
            addCriterion("sell1_price <", value, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceLessThanOrEqualTo(Long value) {
            addCriterion("sell1_price <=", value, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceIn(List<Long> values) {
            addCriterion("sell1_price in", values, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceNotIn(List<Long> values) {
            addCriterion("sell1_price not in", values, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceBetween(Long value1, Long value2) {
            addCriterion("sell1_price between", value1, value2, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell1PriceNotBetween(Long value1, Long value2) {
            addCriterion("sell1_price not between", value1, value2, "sell1Price");
            return (Criteria) this;
        }

        public Criteria andSell2CountIsNull() {
            addCriterion("sell2_count is null");
            return (Criteria) this;
        }

        public Criteria andSell2CountIsNotNull() {
            addCriterion("sell2_count is not null");
            return (Criteria) this;
        }

        public Criteria andSell2CountEqualTo(Integer value) {
            addCriterion("sell2_count =", value, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountNotEqualTo(Integer value) {
            addCriterion("sell2_count <>", value, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountGreaterThan(Integer value) {
            addCriterion("sell2_count >", value, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell2_count >=", value, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountLessThan(Integer value) {
            addCriterion("sell2_count <", value, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountLessThanOrEqualTo(Integer value) {
            addCriterion("sell2_count <=", value, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountIn(List<Integer> values) {
            addCriterion("sell2_count in", values, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountNotIn(List<Integer> values) {
            addCriterion("sell2_count not in", values, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountBetween(Integer value1, Integer value2) {
            addCriterion("sell2_count between", value1, value2, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2CountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell2_count not between", value1, value2, "sell2Count");
            return (Criteria) this;
        }

        public Criteria andSell2PriceIsNull() {
            addCriterion("sell2_price is null");
            return (Criteria) this;
        }

        public Criteria andSell2PriceIsNotNull() {
            addCriterion("sell2_price is not null");
            return (Criteria) this;
        }

        public Criteria andSell2PriceEqualTo(Long value) {
            addCriterion("sell2_price =", value, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceNotEqualTo(Long value) {
            addCriterion("sell2_price <>", value, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceGreaterThan(Long value) {
            addCriterion("sell2_price >", value, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sell2_price >=", value, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceLessThan(Long value) {
            addCriterion("sell2_price <", value, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceLessThanOrEqualTo(Long value) {
            addCriterion("sell2_price <=", value, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceIn(List<Long> values) {
            addCriterion("sell2_price in", values, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceNotIn(List<Long> values) {
            addCriterion("sell2_price not in", values, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceBetween(Long value1, Long value2) {
            addCriterion("sell2_price between", value1, value2, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell2PriceNotBetween(Long value1, Long value2) {
            addCriterion("sell2_price not between", value1, value2, "sell2Price");
            return (Criteria) this;
        }

        public Criteria andSell3CountIsNull() {
            addCriterion("sell3_count is null");
            return (Criteria) this;
        }

        public Criteria andSell3CountIsNotNull() {
            addCriterion("sell3_count is not null");
            return (Criteria) this;
        }

        public Criteria andSell3CountEqualTo(Integer value) {
            addCriterion("sell3_count =", value, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountNotEqualTo(Integer value) {
            addCriterion("sell3_count <>", value, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountGreaterThan(Integer value) {
            addCriterion("sell3_count >", value, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell3_count >=", value, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountLessThan(Integer value) {
            addCriterion("sell3_count <", value, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountLessThanOrEqualTo(Integer value) {
            addCriterion("sell3_count <=", value, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountIn(List<Integer> values) {
            addCriterion("sell3_count in", values, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountNotIn(List<Integer> values) {
            addCriterion("sell3_count not in", values, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountBetween(Integer value1, Integer value2) {
            addCriterion("sell3_count between", value1, value2, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3CountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell3_count not between", value1, value2, "sell3Count");
            return (Criteria) this;
        }

        public Criteria andSell3PriceIsNull() {
            addCriterion("sell3_price is null");
            return (Criteria) this;
        }

        public Criteria andSell3PriceIsNotNull() {
            addCriterion("sell3_price is not null");
            return (Criteria) this;
        }

        public Criteria andSell3PriceEqualTo(Long value) {
            addCriterion("sell3_price =", value, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceNotEqualTo(Long value) {
            addCriterion("sell3_price <>", value, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceGreaterThan(Long value) {
            addCriterion("sell3_price >", value, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sell3_price >=", value, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceLessThan(Long value) {
            addCriterion("sell3_price <", value, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceLessThanOrEqualTo(Long value) {
            addCriterion("sell3_price <=", value, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceIn(List<Long> values) {
            addCriterion("sell3_price in", values, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceNotIn(List<Long> values) {
            addCriterion("sell3_price not in", values, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceBetween(Long value1, Long value2) {
            addCriterion("sell3_price between", value1, value2, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell3PriceNotBetween(Long value1, Long value2) {
            addCriterion("sell3_price not between", value1, value2, "sell3Price");
            return (Criteria) this;
        }

        public Criteria andSell4CountIsNull() {
            addCriterion("sell4_count is null");
            return (Criteria) this;
        }

        public Criteria andSell4CountIsNotNull() {
            addCriterion("sell4_count is not null");
            return (Criteria) this;
        }

        public Criteria andSell4CountEqualTo(Integer value) {
            addCriterion("sell4_count =", value, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountNotEqualTo(Integer value) {
            addCriterion("sell4_count <>", value, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountGreaterThan(Integer value) {
            addCriterion("sell4_count >", value, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell4_count >=", value, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountLessThan(Integer value) {
            addCriterion("sell4_count <", value, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountLessThanOrEqualTo(Integer value) {
            addCriterion("sell4_count <=", value, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountIn(List<Integer> values) {
            addCriterion("sell4_count in", values, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountNotIn(List<Integer> values) {
            addCriterion("sell4_count not in", values, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountBetween(Integer value1, Integer value2) {
            addCriterion("sell4_count between", value1, value2, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4CountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell4_count not between", value1, value2, "sell4Count");
            return (Criteria) this;
        }

        public Criteria andSell4PriceIsNull() {
            addCriterion("sell4_price is null");
            return (Criteria) this;
        }

        public Criteria andSell4PriceIsNotNull() {
            addCriterion("sell4_price is not null");
            return (Criteria) this;
        }

        public Criteria andSell4PriceEqualTo(Long value) {
            addCriterion("sell4_price =", value, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceNotEqualTo(Long value) {
            addCriterion("sell4_price <>", value, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceGreaterThan(Long value) {
            addCriterion("sell4_price >", value, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sell4_price >=", value, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceLessThan(Long value) {
            addCriterion("sell4_price <", value, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceLessThanOrEqualTo(Long value) {
            addCriterion("sell4_price <=", value, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceIn(List<Long> values) {
            addCriterion("sell4_price in", values, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceNotIn(List<Long> values) {
            addCriterion("sell4_price not in", values, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceBetween(Long value1, Long value2) {
            addCriterion("sell4_price between", value1, value2, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell4PriceNotBetween(Long value1, Long value2) {
            addCriterion("sell4_price not between", value1, value2, "sell4Price");
            return (Criteria) this;
        }

        public Criteria andSell5CountIsNull() {
            addCriterion("sell5_count is null");
            return (Criteria) this;
        }

        public Criteria andSell5CountIsNotNull() {
            addCriterion("sell5_count is not null");
            return (Criteria) this;
        }

        public Criteria andSell5CountEqualTo(Integer value) {
            addCriterion("sell5_count =", value, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountNotEqualTo(Integer value) {
            addCriterion("sell5_count <>", value, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountGreaterThan(Integer value) {
            addCriterion("sell5_count >", value, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell5_count >=", value, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountLessThan(Integer value) {
            addCriterion("sell5_count <", value, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountLessThanOrEqualTo(Integer value) {
            addCriterion("sell5_count <=", value, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountIn(List<Integer> values) {
            addCriterion("sell5_count in", values, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountNotIn(List<Integer> values) {
            addCriterion("sell5_count not in", values, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountBetween(Integer value1, Integer value2) {
            addCriterion("sell5_count between", value1, value2, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5CountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell5_count not between", value1, value2, "sell5Count");
            return (Criteria) this;
        }

        public Criteria andSell5PriceIsNull() {
            addCriterion("sell5_price is null");
            return (Criteria) this;
        }

        public Criteria andSell5PriceIsNotNull() {
            addCriterion("sell5_price is not null");
            return (Criteria) this;
        }

        public Criteria andSell5PriceEqualTo(Long value) {
            addCriterion("sell5_price =", value, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceNotEqualTo(Long value) {
            addCriterion("sell5_price <>", value, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceGreaterThan(Long value) {
            addCriterion("sell5_price >", value, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sell5_price >=", value, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceLessThan(Long value) {
            addCriterion("sell5_price <", value, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceLessThanOrEqualTo(Long value) {
            addCriterion("sell5_price <=", value, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceIn(List<Long> values) {
            addCriterion("sell5_price in", values, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceNotIn(List<Long> values) {
            addCriterion("sell5_price not in", values, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceBetween(Long value1, Long value2) {
            addCriterion("sell5_price between", value1, value2, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andSell5PriceNotBetween(Long value1, Long value2) {
            addCriterion("sell5_price not between", value1, value2, "sell5Price");
            return (Criteria) this;
        }

        public Criteria andDealDayIsNull() {
            addCriterion("deal_day is null");
            return (Criteria) this;
        }

        public Criteria andDealDayIsNotNull() {
            addCriterion("deal_day is not null");
            return (Criteria) this;
        }

        public Criteria andDealDayEqualTo(Date value) {
            addCriterionForJDBCDate("deal_day =", value, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("deal_day <>", value, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayGreaterThan(Date value) {
            addCriterionForJDBCDate("deal_day >", value, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_day >=", value, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayLessThan(Date value) {
            addCriterionForJDBCDate("deal_day <", value, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_day <=", value, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayIn(List<Date> values) {
            addCriterionForJDBCDate("deal_day in", values, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("deal_day not in", values, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_day between", value1, value2, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_day not between", value1, value2, "dealDay");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterionForJDBCTime("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterionForJDBCTime("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}