import axios from "axios";
import React, { useEffect, useState } from "react"
import '../images/shop-1.avif'
import '../images/shop-3.jpg'

export default function View () {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        loadProducts();
    }, []);

    const loadProducts = async () => {
        const result = await axios.get("http://localhost:8000/product/all");
        setProducts(result.data);
    };

    return (

    <div>
        <section>
            <div  className="w-full h-36 bg-pink-200 ">
            
        
            <div className="w-full h-full flex justify-center items-center text-gray-700 text-5xl font-serif font-extrabold"><p>Latest Products</p></div>

            </div>
            
           
            
            
        </section>

        <section class="px-6 pb-6 flex items-center justify-center view-height bg-pink-200 relative">
            <div class="w-full sm:inner-view-height border-2 border-black rounded-xl flex overflow-x-auto no-scrollbar flex-auto justify-center items-center relative">
                <div class="flex flex-nowrap">
                    {products.slice(-5).map((product, index) => (
                        <div key={index} class="array-width array-height mx-4 my-4 bg-white border-2 border-red-700 rounded-xl hover:bg-black hover:border-black hover:text-white duration-300">
                            <div className="w-full h-80  duration-300">
                                <img src={product.imageURL} className="w-full h-full rounded-xl" alt="" />
                            </div>
                            <div className="w-full h-16 mt-1">
                                <div className="w-1/2 font-semibold"><p class="pl-2">{product.productName}</p></div>
                                
                                <div className="w-1/2 mt-[-24px] flex relative justify-end items-end gap-1 ml-custom mr-2 "><p className="mr-2"><i class="mt-[-10px] fa-solid fa-indian-rupee-sign"></i> {product.price}</p> </div>
                               
                                <div className="w-1/2 "><p className="pl-2">In Stock: {product.qty}</p></div>
                                
                                <div className="w-[10px] mt-[-24px] ml-52 flex bg hover:text-red-700"><p className="mr-2"><i class="fa-solid fa-heart"></i></p></div>
                            </div>
                            
                        </div>
                    ))}  
                </div>   
            </div> 
        </section>

        <section class="h-32 mx-6">

        </section>

        <section class="mx-6 h-full ">
        {/* <div class="w-full bg-white no-scrollbar flex justify-center items-center"> */}
                <div class="grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-6 justify-center items-center relative">
                    {products.map((product, index) => (
                    <div key={index} class="array-width array-height mx-4 my-4 bg-white border-2 border-red-700 rounded-xl hover:bg-black hover:text-white hover:border-black duration-300">
                    <div className="w-full h-80  duration-300">
                    <img src={product.imageURL} className="w-full h-full rounded-xl" alt="" />
                    </div>
                    <div className="w-full h-16 mt-1">
                        <div className="w-1/2 font-semibold"><p class="pl-2">{product.productName}</p></div>
                        
                        <div className="w-1/2 mt-[-24px] flex relative justify-end items-end gap-1 ml-custom mr-2 "><p className="mr-2"><i class="mt-[-10px] fa-solid fa-indian-rupee-sign"></i> {product.price}</p> </div>
                       
                        <div className="w-1/2 "><p className="pl-2">In Stock: {product.qty}</p></div>
                        
                        <div className="w-[10px] mt-[-24px] ml-52 flex bg hover:text-red-700"><p className="mr-2"><i class="fa-solid fa-heart"></i></p></div>
                    </div>
                    
                </div>
                    ))}  
                </div>   
            {/* </div>  */}
        </section>
        
    </div>   
    )
}