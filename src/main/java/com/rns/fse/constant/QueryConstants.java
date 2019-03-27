package com.rns.fse.constant;

public class QueryConstants {

	public static final String FETCH_TRENDING_ORG="select organization_name, SUM (time_period) as total_hours from rns.sub_request group by organization_name order by total_hours desc";
}
