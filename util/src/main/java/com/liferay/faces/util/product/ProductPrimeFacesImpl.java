/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.util.product;

/**
 * @author  Neil Griffin
 */
public class ProductPrimeFacesImpl extends ProductBaseImpl {

	public ProductPrimeFacesImpl() {

		try {
			Class<?> constantsClass = Class.forName("org.primefaces.util.Constants");
			initVersionInfo((String) constantsClass.getDeclaredField("VERSION").get(String.class));
			this.buildId = (this.majorVersion * 100) + (this.minorVersion * 10) + this.revisionVersion;
			this.title = ProductConstants.PRIMEFACES;

			if (this.majorVersion > 0) {
				this.detected = true;
			}
		}
		catch (Exception e) {
			// Ignore -- PrimeFaces is likely not present.
		}

	}
}
