const NavBar = (props) => {
    return (
        <nav className="navbar navbar-expand-lg navbar navbar-dark bg-dark">
            <a className="navbar-brand" href="#">Dream-Learning <i className="fa fa-cloud" style={{fontSize:35 ,color:'aquamarine'}}></i></a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <a id="home" className="nav-link" href="#home">Home <span className="sr-only">(current)</span></a>
                    </li>


                </ul>
                <form className="form-inline my-2 my-lg-0">
                    <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
                    <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    )
}

export default NavBar;