/*
 * Licensed under MIT (https://github.com/ligoj/ligoj/blob/master/LICENSE)
 */
package org.ligoj.app.plugin.prov.aws.catalog;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.ligoj.app.model.Node;
import org.ligoj.app.plugin.prov.aws.catalog.ec2.AwsEc2Price;
import org.ligoj.app.plugin.prov.model.ProvInstancePrice;
import org.ligoj.app.plugin.prov.model.ProvInstancePriceTerm;
import org.ligoj.app.plugin.prov.model.ProvInstanceType;
import org.ligoj.app.plugin.prov.model.ProvLocation;
import org.ligoj.app.plugin.prov.model.ProvStoragePrice;
import org.ligoj.app.plugin.prov.model.ProvStorageType;

import lombok.Getter;
import lombok.Setter;

/**
 * Context used to perform catalog update.
 */
public class UpdateContext {
	/**
	 * The related AWS {@link Node}
	 */
	@Getter
	@Setter
	private Node node;

	/**
	 * The previously installed instance types. Key is the instance name.
	 */
	@Getter
	@Setter
	private Map<String, ProvInstanceType> instanceTypes;

	/**
	 * The already merge instance types.
	 */
	@Getter
	private Set<String> instanceTypesMerged = new HashSet<>();

	/**
	 * The previously installed price types.
	 */
	@Getter
	@Setter
	private Map<String, ProvInstancePriceTerm> priceTypes;

	/**
	 * The previous installed prices.
	 */
	@Getter
	@Setter
	private Map<String, ProvInstancePrice> previous;

	/**
	 * The previous installed storage prices.
	 */
	@Getter
	@Setter
	private Map<String, ProvStoragePrice> previousStorage;

	/**
	 * The current partial cost for up-front options.
	 */
	@Getter
	@Setter
	private Map<String, AwsEc2Price> partialCost;

	/**
	 * The available regions.
	 */
	@Getter
	@Setter
	private Map<String, ProvLocation> regions;

	/**
	 * The available merged regions.
	 */
	@Getter
	private Set<String> regionsMerged = new HashSet<>();

	/**
	 * The accepted and existing storage type.
	 */
	@Getter
	@Setter
	private Map<String, ProvStorageType> storageTypes;

	/**
	 * The merged storage type.
	 */
	@Getter
	@Setter
	private Map<String, ProvStorageType> storageTypesMerged;

}