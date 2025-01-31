/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.geo.search.aggregations.bucket.geogrid;

import org.opensearch.common.geo.GeoPoint;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.search.aggregations.bucket.GeoTileUtils;

import java.io.IOException;

/**
 * A single geotile grid bucket result parsed between nodes
 *
 * @opensearch.internal
 */
public class ParsedGeoTileGridBucket extends ParsedGeoGridBucket {

    @Override
    public GeoPoint getKey() {
        return GeoTileUtils.keyToGeoPoint(hashAsString);
    }

    @Override
    public String getKeyAsString() {
        return hashAsString;
    }

    static ParsedGeoTileGridBucket fromXContent(XContentParser parser) throws IOException {
        return parseXContent(parser, false, ParsedGeoTileGridBucket::new, (p, bucket) -> bucket.hashAsString = p.text());
    }
}
