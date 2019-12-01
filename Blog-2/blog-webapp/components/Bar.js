import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';

/* In this case we use the bar of material-ui, we copy all the source code
 * in a component, in this particular case we have a function. 
 * The functional components are used for static components tipically, so 
 * components without state. When we develop a functional component instead
 * of defining a class we are defining a function, implicitly this is the 
 * render function.
 * Instead of having class we have a function and the code is directly the 
 * render method. 
 * If we have a component that is not interested in having a state we can wri-
 * te a functional component.
 * In the latest version they added the hooks that can be used to integrate 
 * some functionality in the functional component.
 * By default functional components haven't a state and lyficicle methods.
 * They added some functions called hooks that allow to integrate state and
 * extra stuff, from the class component.
 */
const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export default function Bar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" className={classes.title}>
            News
          </Typography>
          <Button color="inherit">Login</Button>
        </Toolbar>
      </AppBar>
    </div>
  );
}