/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.lesscss.internal.resources;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;
import org.xwiki.lesscss.resources.LESSResourceReference;
import org.xwiki.lesscss.resources.LESSResourceReferenceSerializer;
import org.xwiki.lesscss.resources.LESSSkinFileResourceReference;

/**
 * Specialized implementation of {@link LESSResourceReferenceSerializer} to serialize
 * {@link LESSSkinFileResourceReference} references.
 *
 * @version $Id$
 * @since 6.4M2
 */
@Component
@Named("org.xwiki.lesscss.resources.LESSSkinFileResourceReference")
@Singleton
public class LESSSkinFileResourceReferenceSerializer implements LESSResourceReferenceSerializer
{
    @Inject
    private Logger logger;

    @Override
    public String serialize(LESSResourceReference lessResourceReference)
    {
        if (!(lessResourceReference instanceof LESSSkinFileResourceReference)) {
            logger.warn("Invalid LESS resource type [{}].", lessResourceReference.toString());
            return null;
        }

        LESSSkinFileResourceReference lessSkinFileResourceReference =
            (LESSSkinFileResourceReference) lessResourceReference;
        return String.format("LessSkinFile[%s]", lessSkinFileResourceReference.getFileName());
    }
}
