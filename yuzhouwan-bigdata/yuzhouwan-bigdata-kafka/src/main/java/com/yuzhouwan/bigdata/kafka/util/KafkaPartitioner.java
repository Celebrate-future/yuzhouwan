package com.yuzhouwan.bigdata.kafka.util;

import com.yuzhouwan.common.util.ExceptionUtils;
import com.yuzhouwan.common.util.StrUtils;
import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Copyright @ 2016 yuzhouwan.com
 * All right reserved.
 * Function：Kafka Partitioner
 *
 * @author Benedict Jin
 * @since 2016/12/30
 */
public class KafkaPartitioner implements Partitioner {

    private static final Logger _log = LoggerFactory.getLogger(KafkaPartitioner.class);
    private static final Random r = new Random();

    public KafkaPartitioner(VerifiableProperties vp) {
    }

    @Override
    public int partition(Object key, int numPartitions) {
        return getPartition(key, numPartitions);
    }

    public static int getPartition(Object key, int numPartitions) {
        if (numPartitions <= 1) return 0;
        String keyStr;
        if (key == null || StrUtils.isEmpty(keyStr = key.toString()) || keyStr.length() > 1_000)
            return r.nextInt(numPartitions);
        try {
            if (StrUtils.isNumber(keyStr)) return (int) Math.abs(Long.parseLong(keyStr) % numPartitions);
        } catch (Exception e) {
            _log.error(ExceptionUtils.errorInfo(e));
        }
        return Math.abs(key.hashCode() % numPartitions);
    }
}