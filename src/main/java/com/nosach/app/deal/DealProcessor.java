package com.nosach.app.deal;

import com.nosach.app.models.requests.DealRequest;
import org.springframework.stereotype.Service;

@Service
public interface DealProcessor {
    void processDeal(DealRequest dealRequest);
}
