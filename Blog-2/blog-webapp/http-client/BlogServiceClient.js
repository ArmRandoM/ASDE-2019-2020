import BlogBaseInstance from './BlogBaseInstance'


export default class BlogServiceClient {

    getAllPosts = () => {
        return BlogBaseInstance.get("getAllPosts");
    }

}