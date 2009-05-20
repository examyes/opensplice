/*
 *                         OpenSplice DDS
 *
 *   This software and documentation are Copyright 2006 to 2009 PrismTech 
 *   Limited and its licensees. All rights reserved. See file:
 *
 *                     $OSPL_HOME/LICENSE 
 *
 *   for full copyright notice and license terms. 
 *
 */
package org.opensplice.cm.qos;

import org.opensplice.cm.Time;

/**
 * Indicates the level of reliability offered/requested by the service.
 * 
 * @date Jan 10, 2005 
 */
public class ReliabilityPolicy {
    /**
     * Indicates the level of reliability offered/requested by the Service.
     */
    public ReliabilityKind kind;
    
    /**
     * This setting applies only to the case where kind=RELIABLE and the 
     * HISTORY is KEEP_ALL. The value of the max_blocking_time indicates the 
     * maximum time the operation Writer.write is allowed to block if the 
     * Writer does not have space to store the value written.
     */
    public Time max_blocking_time;
    
    public static final ReliabilityPolicy DEFAULT = new ReliabilityPolicy(ReliabilityKind.BESTEFFORT, new Time(0, 100000000));
    
    /**
     * Constructs a new ReliabilityPolicy.
     *
     * @param _kind The reliability kind.
     * @param _max_blocking_time The maximum time to block a write.
     */
    public ReliabilityPolicy(ReliabilityKind _kind, Time _max_blocking_time){
        kind = _kind;
        max_blocking_time = _max_blocking_time;
    }
    
    public ReliabilityPolicy copy(){
        return new ReliabilityPolicy(this.kind, this.max_blocking_time.copy());
    }
}