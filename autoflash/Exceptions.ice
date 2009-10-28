module autoflash {
module rpc {
module slice{

	exception GenericError {
		string reason;
	};
	
	exception OperationError extends GenericError {};
	
};	// module slice
};	// module rpc
};	// module autoflash