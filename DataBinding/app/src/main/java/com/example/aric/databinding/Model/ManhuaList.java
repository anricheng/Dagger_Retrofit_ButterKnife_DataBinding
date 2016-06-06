package com.example.aric.databinding.Model;

import java.util.List;

/**
 * Created by aric on 16/6/6.
 */
public class ManhuaList {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"currentPage":"1","pagebean":{"allPages":"173","contentlist":[{"id":"/xe/7007659.shtml","link":"http://www.hanhande.com/xe/7007659.shtml","title":"内涵漫画：情人节礼物"},{"id":"/xe/7007658.shtml","link":"http://www.hanhande.com/xe/7007658.shtml","title":"内涵漫画：正确的穿衣方式"}],"maxResult":"15"},"ret_code":0}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * currentPage : 1
     * pagebean : {"allPages":"173","contentlist":[{"id":"/xe/7007659.shtml","link":"http://www.hanhande.com/xe/7007659.shtml","title":"内涵漫画：情人节礼物"},{"id":"/xe/7007658.shtml","link":"http://www.hanhande.com/xe/7007658.shtml","title":"内涵漫画：正确的穿衣方式"}],"maxResult":"15"}
     * ret_code : 0
     */

    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        private String currentPage;
        /**
         * allPages : 173
         * contentlist : [{"id":"/xe/7007659.shtml","link":"http://www.hanhande.com/xe/7007659.shtml","title":"内涵漫画：情人节礼物"},{"id":"/xe/7007658.shtml","link":"http://www.hanhande.com/xe/7007658.shtml","title":"内涵漫画：正确的穿衣方式"}]
         * maxResult : 15
         */

        private PagebeanBean pagebean;
        private int ret_code;

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public static class PagebeanBean {
            private String allPages;
            private String maxResult;
            /**
             * id : /xe/7007659.shtml
             * link : http://www.hanhande.com/xe/7007659.shtml
             * title : 内涵漫画：情人节礼物
             */

            private List<ContentlistBean> contentlist;

            public String getAllPages() {
                return allPages;
            }

            public void setAllPages(String allPages) {
                this.allPages = allPages;
            }

            public String getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(String maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                private String id;
                private String link;
                private String title;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
