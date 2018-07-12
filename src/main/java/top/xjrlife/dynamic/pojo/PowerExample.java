package top.xjrlife.dynamic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PowerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PowerExample() {
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

        public Criteria andPowerNameIsNull() {
            addCriterion("power_name is null");
            return (Criteria) this;
        }

        public Criteria andPowerNameIsNotNull() {
            addCriterion("power_name is not null");
            return (Criteria) this;
        }

        public Criteria andPowerNameEqualTo(String value) {
            addCriterion("power_name =", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotEqualTo(String value) {
            addCriterion("power_name <>", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameGreaterThan(String value) {
            addCriterion("power_name >", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("power_name >=", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLessThan(String value) {
            addCriterion("power_name <", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLessThanOrEqualTo(String value) {
            addCriterion("power_name <=", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLike(String value) {
            addCriterion("power_name like", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotLike(String value) {
            addCriterion("power_name not like", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameIn(List<String> values) {
            addCriterion("power_name in", values, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotIn(List<String> values) {
            addCriterion("power_name not in", values, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameBetween(String value1, String value2) {
            addCriterion("power_name between", value1, value2, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotBetween(String value1, String value2) {
            addCriterion("power_name not between", value1, value2, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerCodeIsNull() {
            addCriterion("power_code is null");
            return (Criteria) this;
        }

        public Criteria andPowerCodeIsNotNull() {
            addCriterion("power_code is not null");
            return (Criteria) this;
        }

        public Criteria andPowerCodeEqualTo(String value) {
            addCriterion("power_code =", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeNotEqualTo(String value) {
            addCriterion("power_code <>", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeGreaterThan(String value) {
            addCriterion("power_code >", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("power_code >=", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeLessThan(String value) {
            addCriterion("power_code <", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeLessThanOrEqualTo(String value) {
            addCriterion("power_code <=", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeLike(String value) {
            addCriterion("power_code like", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeNotLike(String value) {
            addCriterion("power_code not like", value, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeIn(List<String> values) {
            addCriterion("power_code in", values, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeNotIn(List<String> values) {
            addCriterion("power_code not in", values, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeBetween(String value1, String value2) {
            addCriterion("power_code between", value1, value2, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerCodeNotBetween(String value1, String value2) {
            addCriterion("power_code not between", value1, value2, "powerCode");
            return (Criteria) this;
        }

        public Criteria andPowerUrlIsNull() {
            addCriterion("power_url is null");
            return (Criteria) this;
        }

        public Criteria andPowerUrlIsNotNull() {
            addCriterion("power_url is not null");
            return (Criteria) this;
        }

        public Criteria andPowerUrlEqualTo(String value) {
            addCriterion("power_url =", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlNotEqualTo(String value) {
            addCriterion("power_url <>", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlGreaterThan(String value) {
            addCriterion("power_url >", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("power_url >=", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlLessThan(String value) {
            addCriterion("power_url <", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlLessThanOrEqualTo(String value) {
            addCriterion("power_url <=", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlLike(String value) {
            addCriterion("power_url like", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlNotLike(String value) {
            addCriterion("power_url not like", value, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlIn(List<String> values) {
            addCriterion("power_url in", values, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlNotIn(List<String> values) {
            addCriterion("power_url not in", values, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlBetween(String value1, String value2) {
            addCriterion("power_url between", value1, value2, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andPowerUrlNotBetween(String value1, String value2) {
            addCriterion("power_url not between", value1, value2, "powerUrl");
            return (Criteria) this;
        }

        public Criteria andIsMenuIsNull() {
            addCriterion("is_menu is null");
            return (Criteria) this;
        }

        public Criteria andIsMenuIsNotNull() {
            addCriterion("is_menu is not null");
            return (Criteria) this;
        }

        public Criteria andIsMenuEqualTo(Integer value) {
            addCriterion("is_menu =", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotEqualTo(Integer value) {
            addCriterion("is_menu <>", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuGreaterThan(Integer value) {
            addCriterion("is_menu >", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_menu >=", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuLessThan(Integer value) {
            addCriterion("is_menu <", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuLessThanOrEqualTo(Integer value) {
            addCriterion("is_menu <=", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuIn(List<Integer> values) {
            addCriterion("is_menu in", values, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotIn(List<Integer> values) {
            addCriterion("is_menu not in", values, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuBetween(Integer value1, Integer value2) {
            addCriterion("is_menu between", value1, value2, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotBetween(Integer value1, Integer value2) {
            addCriterion("is_menu not between", value1, value2, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentIsNull() {
            addCriterion("is_menu_parent is null");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentIsNotNull() {
            addCriterion("is_menu_parent is not null");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentEqualTo(Integer value) {
            addCriterion("is_menu_parent =", value, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentNotEqualTo(Integer value) {
            addCriterion("is_menu_parent <>", value, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentGreaterThan(Integer value) {
            addCriterion("is_menu_parent >", value, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_menu_parent >=", value, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentLessThan(Integer value) {
            addCriterion("is_menu_parent <", value, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentLessThanOrEqualTo(Integer value) {
            addCriterion("is_menu_parent <=", value, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentIn(List<Integer> values) {
            addCriterion("is_menu_parent in", values, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentNotIn(List<Integer> values) {
            addCriterion("is_menu_parent not in", values, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentBetween(Integer value1, Integer value2) {
            addCriterion("is_menu_parent between", value1, value2, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuParentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_menu_parent not between", value1, value2, "isMenuParent");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidIsNull() {
            addCriterion("is_menu_pid is null");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidIsNotNull() {
            addCriterion("is_menu_pid is not null");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidEqualTo(Integer value) {
            addCriterion("is_menu_pid =", value, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidNotEqualTo(Integer value) {
            addCriterion("is_menu_pid <>", value, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidGreaterThan(Integer value) {
            addCriterion("is_menu_pid >", value, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_menu_pid >=", value, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidLessThan(Integer value) {
            addCriterion("is_menu_pid <", value, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidLessThanOrEqualTo(Integer value) {
            addCriterion("is_menu_pid <=", value, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidIn(List<Integer> values) {
            addCriterion("is_menu_pid in", values, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidNotIn(List<Integer> values) {
            addCriterion("is_menu_pid not in", values, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidBetween(Integer value1, Integer value2) {
            addCriterion("is_menu_pid between", value1, value2, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsMenuPidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_menu_pid not between", value1, value2, "isMenuPid");
            return (Criteria) this;
        }

        public Criteria andIsAvailableIsNull() {
            addCriterion("is_available is null");
            return (Criteria) this;
        }

        public Criteria andIsAvailableIsNotNull() {
            addCriterion("is_available is not null");
            return (Criteria) this;
        }

        public Criteria andIsAvailableEqualTo(Integer value) {
            addCriterion("is_available =", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableNotEqualTo(Integer value) {
            addCriterion("is_available <>", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableGreaterThan(Integer value) {
            addCriterion("is_available >", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_available >=", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableLessThan(Integer value) {
            addCriterion("is_available <", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("is_available <=", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableIn(List<Integer> values) {
            addCriterion("is_available in", values, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableNotIn(List<Integer> values) {
            addCriterion("is_available not in", values, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableBetween(Integer value1, Integer value2) {
            addCriterion("is_available between", value1, value2, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_available not between", value1, value2, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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