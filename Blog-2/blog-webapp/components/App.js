import React from 'react'
import Bar from './Bar'
import Posts from './Posts'
import { CssBaseline } from '@material-ui/core'

/* Since we want a bar on top, we have to import the Bar.js.
 * We define the bar before all the other component.
 * Remember that if we use a component we have to import it.
 * Tipically when we have to use the components of Material-ui we have to import the
 * styles because we want that they appear in the same way in all the browsers.
 * The reason to do that is that different browser have different styles of default.
 * Material-ui has a CssBaseline component that resets the default styles of the brow-
 * sers. 
 */

export default class App extends React.Component {

    render() {
        return (
            <div>
                <CssBaseline />
                <Bar />
                <Posts />
            </div>
        )
    }
}

