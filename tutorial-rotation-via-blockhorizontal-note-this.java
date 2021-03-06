public IBlockState withRotation(IBlockState state, Rotation rot) {
    return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
}

public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
    return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
}

public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
        EntityLivingBase placer) {
    return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
}

public IBlockState getStateFromMeta(int meta) {
    return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
}

public int getMetaFromState(IBlockState state) {
    return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
}

@Override
protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, new IProperty[]{FACING});
}
