/*
 * Copyright 2018-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opencord.igmpproxy;

import java.util.concurrent.atomic.AtomicLong;

public class IgmpStatistics {

    private AtomicLong v2MembershipReportReqRxCounter = new AtomicLong();
    private AtomicLong v3MembershipReportReqRxCounter = new AtomicLong();
    private AtomicLong igmpLeaveReqRxCounter = new AtomicLong();
    private AtomicLong groupSpecificQueriesTxCounter = new AtomicLong();
	private AtomicLong generalQueriesTxCounter = new AtomicLong();
	private AtomicLong unknownIgmpTypePacketsRxCounter = new AtomicLong();
	private AtomicLong reportsRxWithWrongModeCounter = new AtomicLong();
	
    public AtomicLong getReportsRxWithWrongModeCounter() {
		return reportsRxWithWrongModeCounter;
	}

	public AtomicLong getUnknownIgmpTypePacketsRxCounter() {
		return unknownIgmpTypePacketsRxCounter;
	}

	public AtomicLong getGeneralQueriesTxCounter() {
		return generalQueriesTxCounter;
	}

	public AtomicLong getGroupSpecificQueriesTxCounter() {
		return groupSpecificQueriesTxCounter;
	}

    public AtomicLong getIgmpLeaveReqRxCounter() {
		return igmpLeaveReqRxCounter;
	}

	public AtomicLong getV3MembershipReportReqRxCounter() {
		return v3MembershipReportReqRxCounter;
	}

	public AtomicLong getV2MembershipReportReqRxCounter() {
		return v2MembershipReportReqRxCounter;
	}

	public void incrementV3MembershipReportReqRxCounter() {
		v3MembershipReportReqRxCounter.incrementAndGet();
	}

	public void incrementV2MembershipReportReqRxCounter() {
		v2MembershipReportReqRxCounter.incrementAndGet();
	}

    public void incrementIgmpLeaveReqRxCounter() {
    	igmpLeaveReqRxCounter.incrementAndGet();
    }

    public void incrementGroupSpecificQueriesTxCounter() {
    	groupSpecificQueriesTxCounter.incrementAndGet();
    }

    public void incrementGeneralQueriesTxCounter() {
    	generalQueriesTxCounter.incrementAndGet();
    }
    
    public void incrementUnknownIgmpTypePacketsRxCounter() {
    	unknownIgmpTypePacketsRxCounter.incrementAndGet();
    }

    public void incrementReportsRxWithWrongModeCounter() {
    	reportsRxWithWrongModeCounter.incrementAndGet();
    }
}
