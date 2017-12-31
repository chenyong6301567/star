package com.hotyum.stars.dal.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractIncomeDistributionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractIncomeDistributionExample() {
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

        public Criteria andInvestmentAmountIsNull() {
            addCriterion("investment_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIsNotNull() {
            addCriterion("investment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountEqualTo(BigDecimal value) {
            addCriterion("investment_amount =", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotEqualTo(BigDecimal value) {
            addCriterion("investment_amount <>", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountGreaterThan(BigDecimal value) {
            addCriterion("investment_amount >", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("investment_amount >=", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountLessThan(BigDecimal value) {
            addCriterion("investment_amount <", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("investment_amount <=", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIn(List<BigDecimal> values) {
            addCriterion("investment_amount in", values, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotIn(List<BigDecimal> values) {
            addCriterion("investment_amount not in", values, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("investment_amount between", value1, value2, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("investment_amount not between", value1, value2, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andContractIncomeIsNull() {
            addCriterion("contract_income is null");
            return (Criteria) this;
        }

        public Criteria andContractIncomeIsNotNull() {
            addCriterion("contract_income is not null");
            return (Criteria) this;
        }

        public Criteria andContractIncomeEqualTo(Long value) {
            addCriterion("contract_income =", value, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeNotEqualTo(Long value) {
            addCriterion("contract_income <>", value, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeGreaterThan(Long value) {
            addCriterion("contract_income >", value, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeGreaterThanOrEqualTo(Long value) {
            addCriterion("contract_income >=", value, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeLessThan(Long value) {
            addCriterion("contract_income <", value, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeLessThanOrEqualTo(Long value) {
            addCriterion("contract_income <=", value, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeIn(List<Long> values) {
            addCriterion("contract_income in", values, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeNotIn(List<Long> values) {
            addCriterion("contract_income not in", values, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeBetween(Long value1, Long value2) {
            addCriterion("contract_income between", value1, value2, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andContractIncomeNotBetween(Long value1, Long value2) {
            addCriterion("contract_income not between", value1, value2, "contractIncome");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateIsNull() {
            addCriterion("first_trade_date is null");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateIsNotNull() {
            addCriterion("first_trade_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateEqualTo(Date value) {
            addCriterion("first_trade_date =", value, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateNotEqualTo(Date value) {
            addCriterion("first_trade_date <>", value, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateGreaterThan(Date value) {
            addCriterion("first_trade_date >", value, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("first_trade_date >=", value, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateLessThan(Date value) {
            addCriterion("first_trade_date <", value, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateLessThanOrEqualTo(Date value) {
            addCriterion("first_trade_date <=", value, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateIn(List<Date> values) {
            addCriterion("first_trade_date in", values, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateNotIn(List<Date> values) {
            addCriterion("first_trade_date not in", values, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateBetween(Date value1, Date value2) {
            addCriterion("first_trade_date between", value1, value2, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andFirstTradeDateNotBetween(Date value1, Date value2) {
            addCriterion("first_trade_date not between", value1, value2, "firstTradeDate");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNull() {
            addCriterion("product_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNotNull() {
            addCriterion("product_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdEqualTo(Integer value) {
            addCriterion("product_type_id =", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotEqualTo(Integer value) {
            addCriterion("product_type_id <>", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThan(Integer value) {
            addCriterion("product_type_id >", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type_id >=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThan(Integer value) {
            addCriterion("product_type_id <", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_type_id <=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIn(List<Integer> values) {
            addCriterion("product_type_id in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotIn(List<Integer> values) {
            addCriterion("product_type_id not in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id not between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameIsNull() {
            addCriterion("product_type_name is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameIsNotNull() {
            addCriterion("product_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameEqualTo(String value) {
            addCriterion("product_type_name =", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotEqualTo(String value) {
            addCriterion("product_type_name <>", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameGreaterThan(String value) {
            addCriterion("product_type_name >", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_type_name >=", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameLessThan(String value) {
            addCriterion("product_type_name <", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameLessThanOrEqualTo(String value) {
            addCriterion("product_type_name <=", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameLike(String value) {
            addCriterion("product_type_name like", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotLike(String value) {
            addCriterion("product_type_name not like", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameIn(List<String> values) {
            addCriterion("product_type_name in", values, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotIn(List<String> values) {
            addCriterion("product_type_name not in", values, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameBetween(String value1, String value2) {
            addCriterion("product_type_name between", value1, value2, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotBetween(String value1, String value2) {
            addCriterion("product_type_name not between", value1, value2, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateIsNull() {
            addCriterion("trade_end_date is null");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateIsNotNull() {
            addCriterion("trade_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateEqualTo(Date value) {
            addCriterion("trade_end_date =", value, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateNotEqualTo(Date value) {
            addCriterion("trade_end_date <>", value, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateGreaterThan(Date value) {
            addCriterion("trade_end_date >", value, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_end_date >=", value, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateLessThan(Date value) {
            addCriterion("trade_end_date <", value, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateLessThanOrEqualTo(Date value) {
            addCriterion("trade_end_date <=", value, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateIn(List<Date> values) {
            addCriterion("trade_end_date in", values, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateNotIn(List<Date> values) {
            addCriterion("trade_end_date not in", values, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateBetween(Date value1, Date value2) {
            addCriterion("trade_end_date between", value1, value2, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeEndDateNotBetween(Date value1, Date value2) {
            addCriterion("trade_end_date not between", value1, value2, "tradeEndDate");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(Byte value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(Byte value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(Byte value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(Byte value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(Byte value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<Byte> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<Byte> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(Byte value1, Byte value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
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

        public Criteria andDerectRecomandRateIsNull() {
            addCriterion("derect_recomand_rate is null");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateIsNotNull() {
            addCriterion("derect_recomand_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateEqualTo(String value) {
            addCriterion("derect_recomand_rate =", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateNotEqualTo(String value) {
            addCriterion("derect_recomand_rate <>", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateGreaterThan(String value) {
            addCriterion("derect_recomand_rate >", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateGreaterThanOrEqualTo(String value) {
            addCriterion("derect_recomand_rate >=", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateLessThan(String value) {
            addCriterion("derect_recomand_rate <", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateLessThanOrEqualTo(String value) {
            addCriterion("derect_recomand_rate <=", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateLike(String value) {
            addCriterion("derect_recomand_rate like", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateNotLike(String value) {
            addCriterion("derect_recomand_rate not like", value, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateIn(List<String> values) {
            addCriterion("derect_recomand_rate in", values, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateNotIn(List<String> values) {
            addCriterion("derect_recomand_rate not in", values, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateBetween(String value1, String value2) {
            addCriterion("derect_recomand_rate between", value1, value2, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andDerectRecomandRateNotBetween(String value1, String value2) {
            addCriterion("derect_recomand_rate not between", value1, value2, "derectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateIsNull() {
            addCriterion("inderect_recomand_rate is null");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateIsNotNull() {
            addCriterion("inderect_recomand_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateEqualTo(String value) {
            addCriterion("inderect_recomand_rate =", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateNotEqualTo(String value) {
            addCriterion("inderect_recomand_rate <>", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateGreaterThan(String value) {
            addCriterion("inderect_recomand_rate >", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateGreaterThanOrEqualTo(String value) {
            addCriterion("inderect_recomand_rate >=", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateLessThan(String value) {
            addCriterion("inderect_recomand_rate <", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateLessThanOrEqualTo(String value) {
            addCriterion("inderect_recomand_rate <=", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateLike(String value) {
            addCriterion("inderect_recomand_rate like", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateNotLike(String value) {
            addCriterion("inderect_recomand_rate not like", value, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateIn(List<String> values) {
            addCriterion("inderect_recomand_rate in", values, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateNotIn(List<String> values) {
            addCriterion("inderect_recomand_rate not in", values, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateBetween(String value1, String value2) {
            addCriterion("inderect_recomand_rate between", value1, value2, "inderectRecomandRate");
            return (Criteria) this;
        }

        public Criteria andInderectRecomandRateNotBetween(String value1, String value2) {
            addCriterion("inderect_recomand_rate not between", value1, value2, "inderectRecomandRate");
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

        public Criteria andAgentRateIsNull() {
            addCriterion("agent_rate is null");
            return (Criteria) this;
        }

        public Criteria andAgentRateIsNotNull() {
            addCriterion("agent_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAgentRateEqualTo(String value) {
            addCriterion("agent_rate =", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotEqualTo(String value) {
            addCriterion("agent_rate <>", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateGreaterThan(String value) {
            addCriterion("agent_rate >", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateGreaterThanOrEqualTo(String value) {
            addCriterion("agent_rate >=", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLessThan(String value) {
            addCriterion("agent_rate <", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLessThanOrEqualTo(String value) {
            addCriterion("agent_rate <=", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLike(String value) {
            addCriterion("agent_rate like", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotLike(String value) {
            addCriterion("agent_rate not like", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateIn(List<String> values) {
            addCriterion("agent_rate in", values, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotIn(List<String> values) {
            addCriterion("agent_rate not in", values, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateBetween(String value1, String value2) {
            addCriterion("agent_rate between", value1, value2, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotBetween(String value1, String value2) {
            addCriterion("agent_rate not between", value1, value2, "agentRate");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeIsNull() {
            addCriterion("customer_income is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeIsNotNull() {
            addCriterion("customer_income is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeEqualTo(BigDecimal value) {
            addCriterion("customer_income =", value, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeNotEqualTo(BigDecimal value) {
            addCriterion("customer_income <>", value, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeGreaterThan(BigDecimal value) {
            addCriterion("customer_income >", value, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("customer_income >=", value, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeLessThan(BigDecimal value) {
            addCriterion("customer_income <", value, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("customer_income <=", value, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeIn(List<BigDecimal> values) {
            addCriterion("customer_income in", values, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeNotIn(List<BigDecimal> values) {
            addCriterion("customer_income not in", values, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("customer_income between", value1, value2, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andCustomerIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("customer_income not between", value1, value2, "customerIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeIsNull() {
            addCriterion("derect_income is null");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeIsNotNull() {
            addCriterion("derect_income is not null");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeEqualTo(BigDecimal value) {
            addCriterion("derect_income =", value, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeNotEqualTo(BigDecimal value) {
            addCriterion("derect_income <>", value, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeGreaterThan(BigDecimal value) {
            addCriterion("derect_income >", value, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("derect_income >=", value, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeLessThan(BigDecimal value) {
            addCriterion("derect_income <", value, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("derect_income <=", value, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeIn(List<BigDecimal> values) {
            addCriterion("derect_income in", values, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeNotIn(List<BigDecimal> values) {
            addCriterion("derect_income not in", values, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("derect_income between", value1, value2, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andDerectIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("derect_income not between", value1, value2, "derectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeIsNull() {
            addCriterion("inderect_income is null");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeIsNotNull() {
            addCriterion("inderect_income is not null");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeEqualTo(BigDecimal value) {
            addCriterion("inderect_income =", value, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeNotEqualTo(BigDecimal value) {
            addCriterion("inderect_income <>", value, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeGreaterThan(BigDecimal value) {
            addCriterion("inderect_income >", value, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("inderect_income >=", value, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeLessThan(BigDecimal value) {
            addCriterion("inderect_income <", value, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("inderect_income <=", value, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeIn(List<BigDecimal> values) {
            addCriterion("inderect_income in", values, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeNotIn(List<BigDecimal> values) {
            addCriterion("inderect_income not in", values, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inderect_income between", value1, value2, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andInderectIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inderect_income not between", value1, value2, "inderectIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeIsNull() {
            addCriterion("agent_income is null");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeIsNotNull() {
            addCriterion("agent_income is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeEqualTo(BigDecimal value) {
            addCriterion("agent_income =", value, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeNotEqualTo(BigDecimal value) {
            addCriterion("agent_income <>", value, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeGreaterThan(BigDecimal value) {
            addCriterion("agent_income >", value, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("agent_income >=", value, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeLessThan(BigDecimal value) {
            addCriterion("agent_income <", value, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("agent_income <=", value, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeIn(List<BigDecimal> values) {
            addCriterion("agent_income in", values, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeNotIn(List<BigDecimal> values) {
            addCriterion("agent_income not in", values, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agent_income between", value1, value2, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andAgentIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agent_income not between", value1, value2, "agentIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeIsNull() {
            addCriterion("company_income is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeIsNotNull() {
            addCriterion("company_income is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeEqualTo(BigDecimal value) {
            addCriterion("company_income =", value, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeNotEqualTo(BigDecimal value) {
            addCriterion("company_income <>", value, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeGreaterThan(BigDecimal value) {
            addCriterion("company_income >", value, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("company_income >=", value, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeLessThan(BigDecimal value) {
            addCriterion("company_income <", value, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("company_income <=", value, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeIn(List<BigDecimal> values) {
            addCriterion("company_income in", values, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeNotIn(List<BigDecimal> values) {
            addCriterion("company_income not in", values, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_income between", value1, value2, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_income not between", value1, value2, "companyIncome");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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