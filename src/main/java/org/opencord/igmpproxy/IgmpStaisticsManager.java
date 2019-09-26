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

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Activate;
import org.onosproject.event.AbstractListenerManager;
import org.apache.felix.scr.annotations.Deactivate;
//import org.opencord.igmpproxy.IgmpStatistics;
//import org.opencord.igmpproxy.IgmpStatisticsDelegate;
//import org.opencord.igmpproxy.IgmpStatisticsEvent;
//import org.opencord.igmpproxy.IgmpStatisticsEventListener;
//import org.opencord.igmpproxy.IgmpStatisticsService;
import org.apache.felix.scr.annotations.Service;

import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;

@Service
@Component(immediate = true)
public class IgmpStaisticsManager extends
                 AbstractListenerManager<IgmpStatisticsEvent, IgmpStatisticsEventListener>
                         implements IgmpStatisticsService {
    private IgmpStatisticsDelegate statsDelegate;

    private final Logger log = getLogger(getClass());
    private IgmpStatistics igmpStats;


    public IgmpStatistics getIgmpStats() {
        return igmpStats;
    }

    public IgmpStatisticsDelegate getStatsDelegate() {
        return statsDelegate;
    }

        @Activate
        public void activate() {
            igmpStats = new IgmpStatistics();
            statsDelegate = new InternalIgmpDelegateForStatistics();
            eventDispatcher.addSink(IgmpStatisticsEvent.class, listenerRegistry);
            log.info("IgmpStatisticsManager Activated");
        }

        @Deactivate
        public void deactivate() {
            eventDispatcher.removeSink(IgmpStatisticsEvent.class);
            log.info("IgmpStatisticsManager Deactivated");
        }


        /**
         *Delegate allowing the StateMachine to notify us of events.
         */
        private class InternalIgmpDelegateForStatistics implements IgmpStatisticsDelegate {
            @Override
            public void notify(IgmpStatisticsEvent igmpStatisticsEvent) {
                log.debug("Authentication Statistics event {} for {}", igmpStatisticsEvent.type(),
                        igmpStatisticsEvent.subject());
                post(igmpStatisticsEvent);
           }
        }
}
