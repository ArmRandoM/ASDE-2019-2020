import React from 'react'
import BlogBaseInstance from '../http-client/BlogBaseInstance'
import Post from './Post'

/* In this case we want to display a card for all the posts. We create the 
 * Posts component. The posts in this case we are given to us by a Spring 
 * request.
 * In the posts, in the constructor we perform the request using the Blog-
 * Base Intance, and we save it in the state.
 * Now we want to initialize the state, here we want to get the posts using
 * the Blog Base Instance.
 * In the constructor we instantiate the posts using the get of the url ser-
 * vice.
 * Using this get we are not returning the posts but we are returning an ob-
 * ject on which we can perform some actions.
 * The get is not returning the posts, we have to define the state using the 
 * response data. We define the posts using the data of the response.
 * The render will return a view displaying all the posts.
 * We have to have to use always the SetState method if we are outside the con-
 * structor (we cannot modify the state directly). The method is asynchronus 
 * the constructor will not wait to execute a method, this is the reason because
 * we use the SetState.
 * In this case we get all the posts and we want to show all the posts in the 
 * render method. For doing that we will use the same staff that we used in the
 * persons example.
 * In this case we use an expression in which we map each post to some component
 * (using the map method).
 * In the map method we get a post we specify all the post that have to be rende-
 * red.
 * We can create a Post component to which we can pass the data as properties 
 * (props).
 * By using props we can pass data from one component to another component. 
 * Here we have to import the Post Component.
 * In the application we have the data coming from the service. Here we are 
 * mapping each post to a Post Component and then we are passing the data of the
 * post as props. 
 */

export default class Posts extends React.Component {

    constructor(props) {

        super(props)
        this.state = {
            posts: []
        }
        BlogBaseInstance.get("getAllPosts").then((res) => {
            this.setState({
                posts: res.data
            })
        })
    }

    render() {
        return (
            <div>
                <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    color="primary"
                    className="submit"
                    onClick={(event) => this.logginAttempt(event)}>
                    Sign In
                </Button>
                {this.state.posts.map((post) => <Post data={post} />)}
            </div>
        )
    }
}