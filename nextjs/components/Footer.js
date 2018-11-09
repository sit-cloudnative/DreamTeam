const Footer = (props) => {
    return (
        <footer className="page-footer font-small blue pt-4">

            <div className="container">
                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8" >
                        <a href="#">
                            <i className="fa fa-facebook fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                        </a>
                        <a href="#" >
                            <i className="fa fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                        </a>
                        <a href="#">
                            <i className="fa fa-google-plus fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                        </a>
                        <a href="#">
                            <i className="fa fa-linkedin fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                        </a>
                        <a href="#">
                            <i className="fa fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                        </a>
                        <a href="#home" id="Footer" >

                            <i className="fa fa-caret-square-o-up fa-lg white-text mr-md-5 mr-3 fa-2x" aria-hidden="true"> Back to the top</i>

                        </a></div>
                    <div className="col-md-2"></div>
                </div>


            </div>

        </footer>
    )
}


export default Footer;