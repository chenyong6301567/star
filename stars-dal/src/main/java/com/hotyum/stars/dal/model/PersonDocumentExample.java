package com.hotyum.stars.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonDocumentExample() {
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

        public Criteria andDocumentCodeIsNull() {
            addCriterion("document_code is null");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeIsNotNull() {
            addCriterion("document_code is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeEqualTo(String value) {
            addCriterion("document_code =", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeNotEqualTo(String value) {
            addCriterion("document_code <>", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeGreaterThan(String value) {
            addCriterion("document_code >", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("document_code >=", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeLessThan(String value) {
            addCriterion("document_code <", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeLessThanOrEqualTo(String value) {
            addCriterion("document_code <=", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeLike(String value) {
            addCriterion("document_code like", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeNotLike(String value) {
            addCriterion("document_code not like", value, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeIn(List<String> values) {
            addCriterion("document_code in", values, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeNotIn(List<String> values) {
            addCriterion("document_code not in", values, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeBetween(String value1, String value2) {
            addCriterion("document_code between", value1, value2, "documentCode");
            return (Criteria) this;
        }

        public Criteria andDocumentCodeNotBetween(String value1, String value2) {
            addCriterion("document_code not between", value1, value2, "documentCode");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andTradePlatformIsNull() {
            addCriterion("trade_platform is null");
            return (Criteria) this;
        }

        public Criteria andTradePlatformIsNotNull() {
            addCriterion("trade_platform is not null");
            return (Criteria) this;
        }

        public Criteria andTradePlatformEqualTo(String value) {
            addCriterion("trade_platform =", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformNotEqualTo(String value) {
            addCriterion("trade_platform <>", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformGreaterThan(String value) {
            addCriterion("trade_platform >", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformGreaterThanOrEqualTo(String value) {
            addCriterion("trade_platform >=", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformLessThan(String value) {
            addCriterion("trade_platform <", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformLessThanOrEqualTo(String value) {
            addCriterion("trade_platform <=", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformLike(String value) {
            addCriterion("trade_platform like", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformNotLike(String value) {
            addCriterion("trade_platform not like", value, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformIn(List<String> values) {
            addCriterion("trade_platform in", values, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformNotIn(List<String> values) {
            addCriterion("trade_platform not in", values, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformBetween(String value1, String value2) {
            addCriterion("trade_platform between", value1, value2, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradePlatformNotBetween(String value1, String value2) {
            addCriterion("trade_platform not between", value1, value2, "tradePlatform");
            return (Criteria) this;
        }

        public Criteria andTradeAccountIsNull() {
            addCriterion("trade_account is null");
            return (Criteria) this;
        }

        public Criteria andTradeAccountIsNotNull() {
            addCriterion("trade_account is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAccountEqualTo(String value) {
            addCriterion("trade_account =", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountNotEqualTo(String value) {
            addCriterion("trade_account <>", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountGreaterThan(String value) {
            addCriterion("trade_account >", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountGreaterThanOrEqualTo(String value) {
            addCriterion("trade_account >=", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountLessThan(String value) {
            addCriterion("trade_account <", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountLessThanOrEqualTo(String value) {
            addCriterion("trade_account <=", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountLike(String value) {
            addCriterion("trade_account like", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountNotLike(String value) {
            addCriterion("trade_account not like", value, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountIn(List<String> values) {
            addCriterion("trade_account in", values, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountNotIn(List<String> values) {
            addCriterion("trade_account not in", values, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountBetween(String value1, String value2) {
            addCriterion("trade_account between", value1, value2, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andTradeAccountNotBetween(String value1, String value2) {
            addCriterion("trade_account not between", value1, value2, "tradeAccount");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyIsNull() {
            addCriterion("wheather_get_money is null");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyIsNotNull() {
            addCriterion("wheather_get_money is not null");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyEqualTo(Byte value) {
            addCriterion("wheather_get_money =", value, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyNotEqualTo(Byte value) {
            addCriterion("wheather_get_money <>", value, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyGreaterThan(Byte value) {
            addCriterion("wheather_get_money >", value, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyGreaterThanOrEqualTo(Byte value) {
            addCriterion("wheather_get_money >=", value, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyLessThan(Byte value) {
            addCriterion("wheather_get_money <", value, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyLessThanOrEqualTo(Byte value) {
            addCriterion("wheather_get_money <=", value, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyIn(List<Byte> values) {
            addCriterion("wheather_get_money in", values, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyNotIn(List<Byte> values) {
            addCriterion("wheather_get_money not in", values, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyBetween(Byte value1, Byte value2) {
            addCriterion("wheather_get_money between", value1, value2, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andWheatherGetMoneyNotBetween(Byte value1, Byte value2) {
            addCriterion("wheather_get_money not between", value1, value2, "wheatherGetMoney");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateIsNull() {
            addCriterion("get_money_date is null");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateIsNotNull() {
            addCriterion("get_money_date is not null");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateEqualTo(Date value) {
            addCriterion("get_money_date =", value, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateNotEqualTo(Date value) {
            addCriterion("get_money_date <>", value, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateGreaterThan(Date value) {
            addCriterion("get_money_date >", value, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("get_money_date >=", value, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateLessThan(Date value) {
            addCriterion("get_money_date <", value, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateLessThanOrEqualTo(Date value) {
            addCriterion("get_money_date <=", value, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateIn(List<Date> values) {
            addCriterion("get_money_date in", values, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateNotIn(List<Date> values) {
            addCriterion("get_money_date not in", values, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateBetween(Date value1, Date value2) {
            addCriterion("get_money_date between", value1, value2, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andGetMoneyDateNotBetween(Date value1, Date value2) {
            addCriterion("get_money_date not between", value1, value2, "getMoneyDate");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNull() {
            addCriterion("certificate_type is null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("certificate_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeEqualTo(Byte value) {
            addCriterion("certificate_type =", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotEqualTo(Byte value) {
            addCriterion("certificate_type <>", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThan(Byte value) {
            addCriterion("certificate_type >", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("certificate_type >=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThan(Byte value) {
            addCriterion("certificate_type <", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("certificate_type <=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIn(List<Byte> values) {
            addCriterion("certificate_type in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotIn(List<Byte> values) {
            addCriterion("certificate_type not in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeBetween(Byte value1, Byte value2) {
            addCriterion("certificate_type between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("certificate_type not between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNull() {
            addCriterion("certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNotNull() {
            addCriterion("certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberEqualTo(String value) {
            addCriterion("certificate_number =", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotEqualTo(String value) {
            addCriterion("certificate_number <>", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThan(String value) {
            addCriterion("certificate_number >", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_number >=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThan(String value) {
            addCriterion("certificate_number <", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("certificate_number <=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLike(String value) {
            addCriterion("certificate_number like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotLike(String value) {
            addCriterion("certificate_number not like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIn(List<String> values) {
            addCriterion("certificate_number in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotIn(List<String> values) {
            addCriterion("certificate_number not in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberBetween(String value1, String value2) {
            addCriterion("certificate_number between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("certificate_number not between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNull() {
            addCriterion("contract_date is null");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNotNull() {
            addCriterion("contract_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractDateEqualTo(Date value) {
            addCriterion("contract_date =", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotEqualTo(Date value) {
            addCriterion("contract_date <>", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThan(Date value) {
            addCriterion("contract_date >", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThanOrEqualTo(Date value) {
            addCriterion("contract_date >=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThan(Date value) {
            addCriterion("contract_date <", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThanOrEqualTo(Date value) {
            addCriterion("contract_date <=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateIn(List<Date> values) {
            addCriterion("contract_date in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotIn(List<Date> values) {
            addCriterion("contract_date not in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateBetween(Date value1, Date value2) {
            addCriterion("contract_date between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotBetween(Date value1, Date value2) {
            addCriterion("contract_date not between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductRateIsNull() {
            addCriterion("product_rate is null");
            return (Criteria) this;
        }

        public Criteria andProductRateIsNotNull() {
            addCriterion("product_rate is not null");
            return (Criteria) this;
        }

        public Criteria andProductRateEqualTo(String value) {
            addCriterion("product_rate =", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotEqualTo(String value) {
            addCriterion("product_rate <>", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateGreaterThan(String value) {
            addCriterion("product_rate >", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateGreaterThanOrEqualTo(String value) {
            addCriterion("product_rate >=", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateLessThan(String value) {
            addCriterion("product_rate <", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateLessThanOrEqualTo(String value) {
            addCriterion("product_rate <=", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateLike(String value) {
            addCriterion("product_rate like", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotLike(String value) {
            addCriterion("product_rate not like", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateIn(List<String> values) {
            addCriterion("product_rate in", values, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotIn(List<String> values) {
            addCriterion("product_rate not in", values, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateBetween(String value1, String value2) {
            addCriterion("product_rate between", value1, value2, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotBetween(String value1, String value2) {
            addCriterion("product_rate not between", value1, value2, "productRate");
            return (Criteria) this;
        }

        public Criteria andServiceDateIsNull() {
            addCriterion("service_date is null");
            return (Criteria) this;
        }

        public Criteria andServiceDateIsNotNull() {
            addCriterion("service_date is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDateEqualTo(Byte value) {
            addCriterion("service_date =", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotEqualTo(Byte value) {
            addCriterion("service_date <>", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateGreaterThan(Byte value) {
            addCriterion("service_date >", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateGreaterThanOrEqualTo(Byte value) {
            addCriterion("service_date >=", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateLessThan(Byte value) {
            addCriterion("service_date <", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateLessThanOrEqualTo(Byte value) {
            addCriterion("service_date <=", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateIn(List<Byte> values) {
            addCriterion("service_date in", values, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotIn(List<Byte> values) {
            addCriterion("service_date not in", values, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateBetween(Byte value1, Byte value2) {
            addCriterion("service_date between", value1, value2, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotBetween(Byte value1, Byte value2) {
            addCriterion("service_date not between", value1, value2, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andBuyNumIsNull() {
            addCriterion("buy_num is null");
            return (Criteria) this;
        }

        public Criteria andBuyNumIsNotNull() {
            addCriterion("buy_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNumEqualTo(Integer value) {
            addCriterion("buy_num =", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotEqualTo(Integer value) {
            addCriterion("buy_num <>", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumGreaterThan(Integer value) {
            addCriterion("buy_num >", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_num >=", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumLessThan(Integer value) {
            addCriterion("buy_num <", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumLessThanOrEqualTo(Integer value) {
            addCriterion("buy_num <=", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumIn(List<Integer> values) {
            addCriterion("buy_num in", values, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotIn(List<Integer> values) {
            addCriterion("buy_num not in", values, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumBetween(Integer value1, Integer value2) {
            addCriterion("buy_num between", value1, value2, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_num not between", value1, value2, "buyNum");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIsNull() {
            addCriterion("investment_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIsNotNull() {
            addCriterion("investment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountEqualTo(Long value) {
            addCriterion("investment_amount =", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotEqualTo(Long value) {
            addCriterion("investment_amount <>", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountGreaterThan(Long value) {
            addCriterion("investment_amount >", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("investment_amount >=", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountLessThan(Long value) {
            addCriterion("investment_amount <", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountLessThanOrEqualTo(Long value) {
            addCriterion("investment_amount <=", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIn(List<Long> values) {
            addCriterion("investment_amount in", values, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotIn(List<Long> values) {
            addCriterion("investment_amount not in", values, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountBetween(Long value1, Long value2) {
            addCriterion("investment_amount between", value1, value2, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotBetween(Long value1, Long value2) {
            addCriterion("investment_amount not between", value1, value2, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsIsNull() {
            addCriterion("estimated_earnings is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsIsNotNull() {
            addCriterion("estimated_earnings is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsEqualTo(Long value) {
            addCriterion("estimated_earnings =", value, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsNotEqualTo(Long value) {
            addCriterion("estimated_earnings <>", value, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsGreaterThan(Long value) {
            addCriterion("estimated_earnings >", value, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsGreaterThanOrEqualTo(Long value) {
            addCriterion("estimated_earnings >=", value, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsLessThan(Long value) {
            addCriterion("estimated_earnings <", value, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsLessThanOrEqualTo(Long value) {
            addCriterion("estimated_earnings <=", value, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsIn(List<Long> values) {
            addCriterion("estimated_earnings in", values, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsNotIn(List<Long> values) {
            addCriterion("estimated_earnings not in", values, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsBetween(Long value1, Long value2) {
            addCriterion("estimated_earnings between", value1, value2, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andEstimatedEarningsNotBetween(Long value1, Long value2) {
            addCriterion("estimated_earnings not between", value1, value2, "estimatedEarnings");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(Integer value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(Integer value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(Integer value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(Integer value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<Integer> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<Integer> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(Integer value1, Integer value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailIsNull() {
            addCriterion("register_email is null");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailIsNotNull() {
            addCriterion("register_email is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailEqualTo(String value) {
            addCriterion("register_email =", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailNotEqualTo(String value) {
            addCriterion("register_email <>", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailGreaterThan(String value) {
            addCriterion("register_email >", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailGreaterThanOrEqualTo(String value) {
            addCriterion("register_email >=", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailLessThan(String value) {
            addCriterion("register_email <", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailLessThanOrEqualTo(String value) {
            addCriterion("register_email <=", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailLike(String value) {
            addCriterion("register_email like", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailNotLike(String value) {
            addCriterion("register_email not like", value, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailIn(List<String> values) {
            addCriterion("register_email in", values, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailNotIn(List<String> values) {
            addCriterion("register_email not in", values, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailBetween(String value1, String value2) {
            addCriterion("register_email between", value1, value2, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andRegisterEmailNotBetween(String value1, String value2) {
            addCriterion("register_email not between", value1, value2, "registerEmail");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNull() {
            addCriterion("agent_code is null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNotNull() {
            addCriterion("agent_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeEqualTo(String value) {
            addCriterion("agent_code =", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotEqualTo(String value) {
            addCriterion("agent_code <>", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThan(String value) {
            addCriterion("agent_code >", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_code >=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThan(String value) {
            addCriterion("agent_code <", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThanOrEqualTo(String value) {
            addCriterion("agent_code <=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLike(String value) {
            addCriterion("agent_code like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotLike(String value) {
            addCriterion("agent_code not like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIn(List<String> values) {
            addCriterion("agent_code in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotIn(List<String> values) {
            addCriterion("agent_code not in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeBetween(String value1, String value2) {
            addCriterion("agent_code between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotBetween(String value1, String value2) {
            addCriterion("agent_code not between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonIsNull() {
            addCriterion("derect_recomand_person is null");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonIsNotNull() {
            addCriterion("derect_recomand_person is not null");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonEqualTo(String value) {
            addCriterion("derect_recomand_person =", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonNotEqualTo(String value) {
            addCriterion("derect_recomand_person <>", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonGreaterThan(String value) {
            addCriterion("derect_recomand_person >", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonGreaterThanOrEqualTo(String value) {
            addCriterion("derect_recomand_person >=", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonLessThan(String value) {
            addCriterion("derect_recomand_person <", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonLessThanOrEqualTo(String value) {
            addCriterion("derect_recomand_person <=", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonLike(String value) {
            addCriterion("derect_recomand_person like", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonNotLike(String value) {
            addCriterion("derect_recomand_person not like", value, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonIn(List<String> values) {
            addCriterion("derect_recomand_person in", values, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonNotIn(List<String> values) {
            addCriterion("derect_recomand_person not in", values, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonBetween(String value1, String value2) {
            addCriterion("derect_recomand_person between", value1, value2, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandPersonNotBetween(String value1, String value2) {
            addCriterion("derect_recomand_person not between", value1, value2, "derectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonIsNull() {
            addCriterion("inderect_recomand_person is null");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonIsNotNull() {
            addCriterion("inderect_recomand_person is not null");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonEqualTo(String value) {
            addCriterion("inderect_recomand_person =", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonNotEqualTo(String value) {
            addCriterion("inderect_recomand_person <>", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonGreaterThan(String value) {
            addCriterion("inderect_recomand_person >", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonGreaterThanOrEqualTo(String value) {
            addCriterion("inderect_recomand_person >=", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonLessThan(String value) {
            addCriterion("inderect_recomand_person <", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonLessThanOrEqualTo(String value) {
            addCriterion("inderect_recomand_person <=", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonLike(String value) {
            addCriterion("inderect_recomand_person like", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonNotLike(String value) {
            addCriterion("inderect_recomand_person not like", value, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonIn(List<String> values) {
            addCriterion("inderect_recomand_person in", values, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonNotIn(List<String> values) {
            addCriterion("inderect_recomand_person not in", values, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonBetween(String value1, String value2) {
            addCriterion("inderect_recomand_person between", value1, value2, "inderectRecomandPerson");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandPersonNotBetween(String value1, String value2) {
            addCriterion("inderect_recomand_person not between", value1, value2, "inderectRecomandPerson");
            return (Criteria) this;
        }
    }

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