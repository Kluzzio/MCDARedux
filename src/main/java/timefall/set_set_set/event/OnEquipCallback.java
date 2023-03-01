package timefall.set_set_set.event;

//public class OnEquipCallback implements ServerEntityEvents.EquipmentChange {
//
//    Event<ServerEntityEvents.EquipmentChange> ON_EQUIP = EventFactory.createArrayBacked(OnEquipCallback.class,
//            (listeners) -> (livingEntity, equipmentSlot, previous, next) -> {
//                for (OnEquipCallback listener : listeners) {
//                    TypedActionResult result = listener.interact(player, slot);
//
//                    if (result.getResult() != ActionResult.PASS) {
//                        return result;
//                    }
//                }
//                return  TypedActionResult.pass(slot);
//            });
//
//    TypedActionResult interact(PlayerEntity player, EquipmentSlot slot);
//
//    @Override
//    public void onChange(LivingEntity livingEntity, EquipmentSlot equipmentSlot, ItemStack previousStack, ItemStack currentStack) {
//
//    }
//}
