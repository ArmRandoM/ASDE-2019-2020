import React from 'react'
import { Card, CardActionArea, CardContent, Typography, Button, CardActions, CardMedia } from '@material-ui/core'

/* In this case we create a Post component in which we take the data of the props
 * and we store it in the state, or maybe we can render the data directly from the
 * props.
 * In the data we are expecting all the data that we have in the Java Class, so lets
 * write the render method. 
 * In the render method we will display the title, the content of the post and the au-
 * tor.
 * In the post we are basically store the data of the props in the data of the state 
 * and in the render we are displaying the data in the state.
 * We display all the posts using the Card Component of Material-Ui.
 * Instead of copy all the Functional Component we copy it in the render method of the 
 * post. 
 * To use Material-ui we have to install it in the folder of the application. We can use
 * also images through the use of a public url.
 */

export default class Post extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            data: props.data
        }
    }


    /* A card is used to display some information, is a kind of panel. We use
     * a card for each post displaying all the information for each post. 
     */
    render() {
        return (
            <div>
                <Card>
                    <CardActionArea>
                        <CardMedia
                            image="/static/images/cards/contemplative-reptile.jpg"
                            title="Contemplative Reptile"
                        />
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="h2">
                                {this.state.data.title}
                            </Typography>
                            <Typography variant="body2" color="textSecondary" component="p">
                                {this.state.data.message}
                            </Typography>
                            <Typography variant="body2" color="textSecondary" component="p">
                                Posted by {this.state.data.author}
                            </Typography>
                        </CardContent>
                    </CardActionArea>
                    <CardActions>
                        <Button size="small" color="primary">
                            Share
                        </Button>
                        <Button size="small" color="primary">
                            Learn More
                        </Button>
                    </CardActions>
                </Card>
            </div>
        )
    }

}