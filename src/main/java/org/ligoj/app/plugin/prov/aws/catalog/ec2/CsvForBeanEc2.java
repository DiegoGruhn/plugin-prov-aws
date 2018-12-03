/*
 * Licensed under MIT (https://github.com/ligoj/ligoj/blob/master/LICENSE)
 */
package org.ligoj.app.plugin.prov.aws.catalog.ec2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.ligoj.app.plugin.prov.aws.catalog.AbstractAwsCsvForBean;
import org.ligoj.app.plugin.prov.aws.catalog.AwsCsvReader;
import org.ligoj.bootstrap.core.csv.CsvBeanReader;

/**
 * Read AWS EC2 CSV input, skipping the AWS headers and non instance type rows.
 */
public class CsvForBeanEc2 extends AbstractAwsCsvForBean<AwsEc2Price> {

	/**
	 * EC2 CSV Mapping to Java bean property
	 */
	private static final Map<String, String> HEADERS_MAPPING = new HashMap<>();
	static {
		HEADERS_MAPPING.put("Unit", "priceUnit");
		HEADERS_MAPPING.put("LeaseContractLength", "leaseContractLength");
		HEADERS_MAPPING.put("PurchaseOption", "purchaseOption");
		HEADERS_MAPPING.put("OfferingClass", "offeringClass");
		HEADERS_MAPPING.put("Instance Type", "instanceType");
		HEADERS_MAPPING.put("vCPU", "cpu");
		HEADERS_MAPPING.put("Physical Processor", "physicalProcessor");
		HEADERS_MAPPING.put("Clock Speed", "clockSpeed");
		HEADERS_MAPPING.put("Memory", "memory");
		HEADERS_MAPPING.put("Tenancy", "tenancy");
		HEADERS_MAPPING.put("Operating System", "os");
		HEADERS_MAPPING.put("License Model", "licenseModel");
		HEADERS_MAPPING.put("ECU", "ecu");
		HEADERS_MAPPING.put("Pre Installed S/W", "software");
		HEADERS_MAPPING.put("Network Performance", "networkPerformance");
		HEADERS_MAPPING.put("EBS Optimized", "ebsOptimized");
		HEADERS_MAPPING.put("Current Generation", "currentGeneration");
		HEADERS_MAPPING.put("CapacityStatus", "capacityStatus");
	}

	/**
	 * Build the reader parsing the CSV file from AWS to build {@link AwsEc2Price} instances. Non AWS instances data are
	 * skipped, and headers are ignored.
	 *
	 * @param reader
	 *            The original AWS CSV input.
	 * @throws IOException
	 *             When CSV content cannot be read.
	 */
	public CsvForBeanEc2(final BufferedReader reader) throws IOException {
		super(reader, HEADERS_MAPPING, AwsEc2Price.class);
	}

	@Override
	protected CsvBeanReader<AwsEc2Price> newCsvReader(final Reader reader, final String[] headers,
			final Class<AwsEc2Price> beanType) {
		return new AwsCsvReader<>(reader, headers, beanType) {

			@Override
			protected boolean isValidRaw(final List<String> rawValues) {
				// Only Compute Instance with a valid OS
				// Only Compute instance for now
				// Only OS compliant
				// Only Tenancy compliant : no "host"/"NA"
				// No dedicated host for now
				// CapacityStatus = 'Used'
				return rawValues.size() > 48 && "Compute Instance".equals(rawValues.get(14))
						&& !"NA".equals(StringUtils.defaultIfEmpty(rawValues.get(37), "NA"))
						&& !"NA".equals(rawValues.get(35)) && !"Host".equals(rawValues.get(35))
						&& "Used".equals(StringUtils.defaultIfBlank(rawValues.get(48), "Used"));
			}

		};
	}

}