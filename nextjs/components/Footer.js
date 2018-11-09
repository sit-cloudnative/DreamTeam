const Footer = (props) => {
    return (
        <footer className="page-footer font-small black pt-4">
            <div className="container">
                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8" >
                        <div className="card-footer">
                            <div className="d-flex justify-content-center links fa-md">
                                <a href="https://github.com/sit-cloudnative/DreamTeam" target="_blank">
                                    <i class="fa fa-github  white-text"> Our GitHub</i>
                                </a>
                                <div class="mr-3"></div>
                                &#9400; DreamTeam & INT491 CloudNative
                        </div>
                        </div>
                    </div>
                    <div className="col-md-2">
                        <a href="#home" id="Footer" >
                            <i className="fa fa-caret-square-o-up fa-lg white-text"  > Back to the top</i>
                        </a>
                    </div>
                </div>
            </div>
        </footer>
    )
}


export default Footer;