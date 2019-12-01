import axios from 'axios'

/* Is better to define a new file that is related to http requests. This is 
 * an Axios Base Instance in order to avoid the duplication of the url within 
 * the code. 
 * This Base Instance is used to define a configuration using Axios to a given
 * service and then we can use it whenever we need.
 * The configuration is the url to the service, the address of the service.
 */
export default axios.create({
    baseURL: "http://localhost:8080/blog-service/"
});