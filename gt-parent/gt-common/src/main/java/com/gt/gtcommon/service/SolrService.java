//package com.gt.gtcommon.service;
//
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.apache.solr.client.solrj.impl.XMLResponseParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SolrService<T> {
//    /**
//     * 定义http的solr服务
//     */
//    @Autowired
//    private static HttpSolrServer httpSolrServer;
//
//    @Value("spring.data.solr.host")
//    private static String url;
//
//    /**
//     * 自己写地址
//     */
//    static {
////		String url = "http://localhost/8983/solr/sj";
////        String url = "http://localhost:8983/solr/sj";
//        // 定义solr 的server
//        httpSolrServer = new HttpSolrServer(url);
//        // 设置响应解析器
//        httpSolrServer.setParser(new XMLResponseParser());
//        // 设置重试次数，推荐设置为1
//        httpSolrServer.setMaxRetries(1);
//        // 建立连接的最大时间
//        httpSolrServer.setConnectionTimeout(500);
//    }
//
//    /**
//     * 新增数据到solr服务
//     *
//     * 存入的时候 查看item的属性里边有没有设置主键 主键(id)一样就是修改，不一样就是新增
//     *
//     * @param t
//     * @throws Exception
//     */
//    public void saveOrUpdate(T t) throws Exception {
//        // 添加数据到solr服务器
//        httpSolrServer.addBean(t);
//        // 提交
//        httpSolrServer.commit();
//    }
//
//    // 查询并返回存有总记录数及页面需要的列表数据的map
//  /*  public EasyUIResult queryTotalAndList(String keywords, Integer page, Integer rows) throws Exception {
//        EasyUIResult result = new EasyUIResult();
//
//        SolrQuery solrQuery = new SolrQuery(); // 构建搜索条件
//        // solrQuery.setQuery("sellPoint:" + keywords); //设置搜索关键词
//        solrQuery.setQuery("searchText:" + keywords); // 设置搜索关键词
//        // 设置分页 查询时开始行。
//        solrQuery.setStart((Math.max(page, 1) - 1) * rows);
//        // 设置分页查询时，页大小
//        solrQuery.setRows(rows);
//        // 设置高亮处理后返回的字符串长度
//        solrQuery.setHighlightFragsize(40);
//
//        // 是否需要高亮
//        boolean isHighlighting = !StringUtils.equals("*", keywords) && StringUtils.isNotEmpty(keywords);
//        if (isHighlighting) {
//            // 设置高亮
//            solrQuery.setHighlight(true); // 开启高亮组件
//            // solrQuery.addHighlightField("sellPoint");// 高亮字段
//            solrQuery.addHighlightField("sellPoint");// 高亮字段
//            solrQuery.addHighlightField("title");// 高亮字段
//            solrQuery.setHighlightSimplePre("<font style='color:red'>");// 标记，高亮关键字前缀
//            solrQuery.setHighlightSimplePost("</font>");// 后缀
//        }
//
//        // 执行查询
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        // 设置总记录数
//        result.setTotal((int) queryResponse.getResults().getNumFound());
//
//        // 获取列表信息并遍历进行高亮处理
//        List<Item> list = queryResponse.getBeans(Item.class);
//        if (isHighlighting) {
//            // 将高亮的标题数据写回到数据对象中
//            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
//            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
//                for (Item item : list) {
//                    if (!highlighting.getKey().equals(item.getId().toString())) {
//                        continue;
//                    }
//                    item.setSellPoint(StringUtils.join(highlighting.getValue().get("sellPoint"), ""));
//                    item.setTitle(StringUtils.join(highlighting.getValue().get("title"), ""));
//                    break;
//                }
//            }
//        }
//        // 设置记录列表到返回的map中
//        result.setRows(list);
//        // 返回存有总记录数及页面需要的列表数据
//        return result;
//    }*/
//
//
//    public void deleteByIds(List<String> ids) throws Exception {
//        httpSolrServer.deleteById(ids);
//        httpSolrServer.commit(); // 提交
//    }
//
//    public void deleteByQuery() throws Exception {
//        httpSolrServer.deleteByQuery("*:*"); // 清空文档库
//        httpSolrServer.commit();
//    }
//}
//
