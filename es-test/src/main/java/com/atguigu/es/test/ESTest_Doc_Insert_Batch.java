package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Description：
 * Author: Dharma
 * Create: 2021/9/14 10:45
 **/

public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 批量插入数据
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan","age",30,"sex","男"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","age",30,"sex","女"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu","age",40,"sex","男"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","wangwu1","age",40,"sex","女"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","wangwu2","age",50,"sex","男"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","wangwu3","age",50,"sex","男"));

        BulkResponse response = esClient.bulk(request,RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());

        // 关闭ES客户端
        esClient.close();
    }
}
