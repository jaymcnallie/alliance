/**
 * Copyright (c) Connexta, LLC
 * <p/>
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.connexta.alliance.libs.klv;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import ddf.catalog.data.Attribute;
import ddf.catalog.data.impl.AttributeImpl;

abstract class BaseKlvHandler implements KlvHandler {

    private String attributeName;

    public BaseKlvHandler(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public String getAttributeName() {
        return this.attributeName;
    }

    protected final <T extends Serializable> Optional<Attribute> asAttribute(Collection<T> col) {
        if (col.isEmpty()) {
            return Optional.empty();
        }
        List<Serializable> serials = new LinkedList<>(col);
        return Optional.of(new AttributeImpl(getAttributeName(), serials));
    }

}
