package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * Description：
 * Author: Dharma
 * Create: 2021/9/14 10:10
 **/

public class ESTest_Index_Delete {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 创建索引
        DeleteIndexRequest request = new DeleteIndexRequest("user");

        AcknowledgedResponse response =
                esClient.indices().delete(request, RequestOptions.DEFAULT);

        // 响应状态
        System.out.println(response.isAcknowledged());

        // 关闭ES客户端
        esClient.close();
    }
}
