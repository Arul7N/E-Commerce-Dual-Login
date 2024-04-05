import { Route, Routes, Navigate } from "react-router-dom";
import NewProduct from "./NewProduct";
import Home from "./Home";
import ProductAdded from "./ProductAdded";
import Edit from "./components/Edit";
import Delete from "./components/Delete";
import View from "./components/View";



function Routers () {
    return (
    <Routes>
        <Route path="/" element={<Navigate to='/home' />} />
        <Route path='/home/new' element={<NewProduct />} />
        <Route path="/home" element={<Home />} />
        <Route path='/added' element={<ProductAdded />} />
        <Route path='/home/edit' element={<Edit />} />
        <Route path='/home/delete' element={<Delete />} />
        <Route path='/added/new' element={<NewProduct />} />
        <Route path='/home/view' element={<View />} />
    </Routes>
    )
}

export default Routers;