package com.cloud.contentcenter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareExample() {
        oredCriteria = new ArrayList<>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNull() {
            addCriterion("is_original is null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNotNull() {
            addCriterion("is_original is not null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalEqualTo(Boolean value) {
            addCriterion("is_original =", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotEqualTo(Boolean value) {
            addCriterion("is_original <>", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThan(Boolean value) {
            addCriterion("is_original >", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_original >=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThan(Boolean value) {
            addCriterion("is_original <", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThanOrEqualTo(Boolean value) {
            addCriterion("is_original <=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIn(List<Boolean> values) {
            addCriterion("is_original in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotIn(List<Boolean> values) {
            addCriterion("is_original not in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalBetween(Boolean value1, Boolean value2) {
            addCriterion("is_original between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_original not between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNull() {
            addCriterion("download_url is null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNotNull() {
            addCriterion("download_url is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlEqualTo(String value) {
            addCriterion("download_url =", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotEqualTo(String value) {
            addCriterion("download_url <>", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThan(String value) {
            addCriterion("download_url >", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("download_url >=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThan(String value) {
            addCriterion("download_url <", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("download_url <=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLike(String value) {
            addCriterion("download_url like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotLike(String value) {
            addCriterion("download_url not like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIn(List<String> values) {
            addCriterion("download_url in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotIn(List<String> values) {
            addCriterion("download_url not in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlBetween(String value1, String value2) {
            addCriterion("download_url between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("download_url not between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNull() {
            addCriterion("buy_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNotNull() {
            addCriterion("buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountEqualTo(Integer value) {
            addCriterion("buy_count =", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotEqualTo(Integer value) {
            addCriterion("buy_count <>", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThan(Integer value) {
            addCriterion("buy_count >", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_count >=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThan(Integer value) {
            addCriterion("buy_count <", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_count <=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountIn(List<Integer> values) {
            addCriterion("buy_count in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotIn(List<Integer> values) {
            addCriterion("buy_count not in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_count between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_count not between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andShowFlagIsNull() {
            addCriterion("show_flag is null");
            return (Criteria) this;
        }

        public Criteria andShowFlagIsNotNull() {
            addCriterion("show_flag is not null");
            return (Criteria) this;
        }

        public Criteria andShowFlagEqualTo(Boolean value) {
            addCriterion("show_flag =", value, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagNotEqualTo(Boolean value) {
            addCriterion("show_flag <>", value, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagGreaterThan(Boolean value) {
            addCriterion("show_flag >", value, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("show_flag >=", value, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagLessThan(Boolean value) {
            addCriterion("show_flag <", value, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("show_flag <=", value, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagIn(List<Boolean> values) {
            addCriterion("show_flag in", values, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagNotIn(List<Boolean> values) {
            addCriterion("show_flag not in", values, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("show_flag between", value1, value2, "showFlag");
            return (Criteria) this;
        }

        public Criteria andShowFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("show_flag not between", value1, value2, "showFlag");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }
    }

    /**
     *
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